package ir.foodwebapp.model.bl;

import ir.foodwebapp.model.da.OrderDA;
import ir.foodwebapp.model.da.OrderViewDA;
import ir.foodwebapp.model.entity.Order;
import ir.foodwebapp.model.entity.OrderView;

import java.time.LocalDate;
import java.util.List;

public class OrderBL {
    private static OrderBL orderBL = new OrderBL();

    private OrderBL() {
    }

    public static OrderBL getOrderBL() {
        return orderBL;
    }

    public Order add(Order order) throws Exception {
        try(OrderDA orderDA = new OrderDA()){
            return orderDA.add(order);
        }
    }

    public Order edit(Order order) throws Exception {
        try(OrderDA orderDA = new OrderDA()){
            return orderDA.edit(order);
        }
    }

    public List<OrderView> findByNameAndFamily(String customerName, String customerFamily) throws Exception {
        try(OrderViewDA orderViewDA = new OrderViewDA()){
            return orderViewDA.findByNameAndFamily(customerName, customerFamily);
        }
    }

    public List<OrderView> findByTypeAndName(String foodType, String foodName) throws Exception {
        try(OrderViewDA orderViewDA = new OrderViewDA()){
            return orderViewDA.findByTypeAndName(foodType, foodName);
        }
    }

    public List<OrderView> findByDate(LocalDate date) throws Exception {
        try(OrderViewDA orderViewDA = new OrderViewDA()){
            return orderViewDA.findByDate(date);
        }
    }

    public Order remove(long id) throws Exception {
        try(OrderDA orderDA = new OrderDA()){
            return orderDA.remove(id);
        }
    }


    public Order findById(long id) throws Exception {
        try(OrderDA orderDA = new OrderDA()){
            return orderDA.findById(id);
        }
    }
}
