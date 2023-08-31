package ir.foodwebapp.model.entity;

import com.google.gson.Gson;

public class Food {
    private long id;
    private String type;
    private String name;

    public Food(long id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Food(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public Food() {
    }

    public long getId() {
        return id;
    }

    public Food setId(long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Food setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Food setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
