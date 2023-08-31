package ir.foodwebapp.model.bl;

import ir.foodwebapp.model.da.FoodDA;
import ir.foodwebapp.model.entity.Food;

import java.util.List;

public class FoodBL {
    private static FoodBL foodBL = new FoodBL();

    private FoodBL() {
    }

    public static FoodBL getFoodBL() {
        return foodBL;
    }

    public Food add(Food food) throws Exception {
        try(FoodDA foodDA = new FoodDA()){
            return foodDA.add(food);
        }
    }

    public Food edit(Food food) throws Exception {
        try(FoodDA foodDA = new FoodDA()){
            return foodDA.edit(food);
        }
    }

    public Food remove(long id) throws Exception {
        try(FoodDA foodDA = new FoodDA()){
            return foodDA.remove(id);
        }
    }

    public Food findById(long id) throws Exception {
        try(FoodDA foodDA = new FoodDA()){
            return foodDA.findById(id);
        }
    }

    public List<Food> findAll() throws Exception {
        try(FoodDA foodDA = new FoodDA()){
            return foodDA.findAll();
        }
    }

}
