package ir.foodwebapp.model.entity;

import java.time.LocalDateTime;

public class Order {
    private long id;
    private long customerId;
    private long foodId;
    private LocalDateTime orderTime;
    private int tableNumber;

    public Order(long id, long customerId, long foodId, LocalDateTime orderTime, int tableNumber) {
        this.id = id;
        this.customerId = customerId;
        this.foodId = foodId;
        this.orderTime = orderTime;
        this.tableNumber = tableNumber;
    }

    public Order(long customerId, long foodId, LocalDateTime orderTime) {
        this.customerId = customerId;
        this.foodId = foodId;
        this.orderTime = orderTime;
    }

    public Order(long customerId, long foodId) {
        this.customerId = customerId;
        this.foodId = foodId;
    }

    public Order(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Order() {
    }

    public Order(long customerId, long foodId, LocalDateTime orderTime, int tableNumber) {
        this.customerId = customerId;
        this.foodId = foodId;
        this.orderTime = orderTime;
        this.tableNumber = tableNumber;
    }

    public long getCustomerId() {
        return customerId;
    }

    public Order setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public long getFoodId() {
        return foodId;
    }

    public Order setFoodId(long foodId) {
        this.foodId = foodId;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public Order setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Order setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
        return this;
    }

    public long getId() {
        return id;
    }

    public Order setId(long id) {
        this.id = id;
        return this;
    }
}
