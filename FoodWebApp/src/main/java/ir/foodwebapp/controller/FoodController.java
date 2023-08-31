package ir.foodwebapp.controller;

import ir.foodwebapp.model.bl.FoodBL;
import ir.foodwebapp.model.bl.OrderBL;
import ir.foodwebapp.model.bl.ReceptionBL;
import ir.foodwebapp.model.entity.Food;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class FoodController {
    private static FoodController foodController = new FoodController();

    private FoodController() {
    }

    public static FoodController getFoodController() {
        return foodController;
    }

    public String add(String type, String name) {
        try {
            if (type != null && !type.isEmpty() && name != null && !name.isEmpty()) {
                Food food = new Food(type, name);
                return FoodBL.getFoodBL().add(food).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

    public String edit(String type, String name) {
        try {
            if (type != null && !type.isEmpty() && name != null && !name.isEmpty()) {
                Food food = new Food(type, name);
                return FoodBL.getFoodBL().edit(food).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String remove(long id){
        try {
            if (id != 0) {
                return FoodBL.getFoodBL().remove(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
    public String findById(long id) {
        try {
            if (id != 0) {
                return FoodBL.getFoodBL().findById(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
}
