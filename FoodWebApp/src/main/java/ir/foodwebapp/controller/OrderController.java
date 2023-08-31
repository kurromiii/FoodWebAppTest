package ir.foodwebapp.controller;

import ir.foodwebapp.model.bl.OrderBL;
import ir.foodwebapp.model.entity.Order;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderController {
    private static OrderController orderController = new OrderController();

    private OrderController() {
    }

    public static OrderController getOrderController() {
        return orderController;
    }

    public String add(long customerId, long foodId, LocalDateTime orderTime, int tableNumber) {
        try {
            if (customerId != 0 && foodId != 0 && orderTime != null && tableNumber != 0) {
                Order order = new Order(customerId, foodId, orderTime, tableNumber);
                return OrderBL.getOrderBL().add(order).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

    public String edit(long customerId, long foodId, LocalDateTime orderTime, int tableNumber) {
        try {
            if (customerId != 0 && foodId != 0 && orderTime != null && tableNumber != 0) {
                Order order = new Order(customerId, foodId, orderTime, tableNumber);
                return OrderBL.getOrderBL().edit(order).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

//order
    public String findById(long id) {
        try {
            if (id != 0) {
                return OrderBL.getOrderBL().findById(id).toString();
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
                return OrderBL.getOrderBL().remove(id).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
//customer
    public String findByNameAndFamily(String customerName, String customerFamily) {
        try {
            if (customerName != null && !customerName.isEmpty() && customerFamily != null && !customerFamily.isEmpty()) {
                return OrderBL.getOrderBL().findByNameAndFamily(customerName,customerFamily).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
//food
    public String findByTypeAndName(String foodType, String foodName) {
        try {
            if (foodType != null && !foodType.isEmpty() && foodName != null && !foodName.isEmpty()) {
                return OrderBL.getOrderBL().findByTypeAndName(foodType,foodName).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }
//orderTime
    public String findByDate(LocalDate date) {
        try {
            if (date != null) {
                return OrderBL.getOrderBL().findByDate(date).toString();
            } else {
                throw new ValueException("Enter required information correctly!");
            }
        } catch (Exception e) {
            return ExceptionWrapper.getMessage(e);
        }
    }

}
