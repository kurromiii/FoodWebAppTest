package ir.foodwebapp.model.entity;

import com.google.gson.Gson;

public class Customer extends Person{

    public Customer(String name, String family) {
        super(name, family);
    }

    public Customer(long id, String name, String family, String phoneNumber, boolean status) {
        super(id, name, family, phoneNumber, status);
    }

    public Customer(String name, String family, String phoneNumber, boolean status) {
        super(name, family, phoneNumber, status);
    }

    public Customer(String name, String family, String phoneNumber) {
        super(name, family, phoneNumber);
    }

    public Customer() {
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
