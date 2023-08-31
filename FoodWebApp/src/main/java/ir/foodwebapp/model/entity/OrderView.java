package ir.foodwebapp.model.entity;

import com.google.gson.Gson;
import java.time.LocalDateTime;

public class OrderView {
    private long customerId;
    private String customerName;
    private String customerFamily;
    private String customerPhone;
    private boolean customerStatus;
    private long foodId;
    private String foodType;
    private String foodName;
    private long orderId;
    private LocalDateTime orderTime;

    public OrderView(long customerId, String customerName, String customerFamily, String customerPhone, boolean customerStatus, long foodId, String foodType, String foodName, long orderId, LocalDateTime orderTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerPhone = customerPhone;
        this.customerStatus = customerStatus;
        this.foodId = foodId;
        this.foodType = foodType;
        this.foodName = foodName;
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    public OrderView(String customerName, String customerFamily, String customerPhone, boolean customerStatus, String foodType, String foodName, LocalDateTime orderTime) {
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerPhone = customerPhone;
        this.customerStatus = customerStatus;
        this.foodType = foodType;
        this.foodName = foodName;
        this.orderTime = orderTime;
    }

    public OrderView(long customerId, String customerName, String customerFamily, String customerPhone, long foodId, String foodType, String foodName, long orderId, LocalDateTime orderTime) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerPhone = customerPhone;
        this.foodId = foodId;
        this.foodType = foodType;
        this.foodName = foodName;
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    public OrderView(long customerId, String customerName, String customerFamily, String customerPhone, long foodId, String foodType, String foodName, long orderId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerPhone = customerPhone;
        this.foodId = foodId;
        this.foodType = foodType;
        this.foodName = foodName;
        this.orderId = orderId;
    }

    public OrderView(String customerName, String customerFamily, String customerPhone) {
        this.customerName = customerName;
        this.customerFamily = customerFamily;
        this.customerPhone = customerPhone;
    }

    public OrderView(String foodType, String foodName) {
        this.foodType = foodType;
        this.foodName = foodName;
    }

    public OrderView(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public OrderView(long orderId) {
        this.orderId = orderId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public OrderView setCustomerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderView setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public String getCustomerFamily() {
        return customerFamily;
    }

    public OrderView setCustomerFamily(String customerFamily) {
        this.customerFamily = customerFamily;
        return this;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public OrderView setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public boolean isCustomerStatus() {
        return customerStatus;
    }

    public OrderView setCustomerStatus(boolean customerStatus) {
        this.customerStatus = customerStatus;
        return this;
    }

    public long getFoodId() {
        return foodId;
    }

    public OrderView setFoodId(long foodId) {
        this.foodId = foodId;
        return this;
    }

    public String getFoodType() {
        return foodType;
    }

    public OrderView setFoodType(String foodType) {
        this.foodType = foodType;
        return this;
    }

    public String getFoodName() {
        return foodName;
    }

    public OrderView setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
    }

    public long getOrderId() {
        return orderId;
    }

    public OrderView setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public OrderView setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
