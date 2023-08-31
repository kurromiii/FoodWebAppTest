package ir.foodwebapp.model.entity;

import com.google.gson.Gson;

public class Person {
    private long id;
    private String name;
    private String family;
    private String phoneNumber;
    private boolean status;

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Person(long id, String name, String family, String phoneNumber, boolean status) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Person(String name, String family, String phoneNumber, boolean status) {
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

    public Person(String name, String family, String phoneNumber) {
        this.name = name;
        this.family = family;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public Person setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public boolean getStatus() {
        return status;
    }

    public Person setStatus(boolean status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
