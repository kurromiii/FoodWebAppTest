package ir.foodwebapp.model.da;

import ir.foodwebapp.model.entity.Food;
import ir.foodwebapp.model.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FoodDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;

    public FoodDA() throws Exception, ClassNotFoundException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public Food add(Food food) throws Exception {
        statement = connection.prepareStatement(
                "SELECT food_seq.nextval as id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        food.setId(resultSet.getLong("id"));

        statement = connection.prepareStatement(
                "INSERT INTO food VALUES(?,?, ?)");
        statement.setLong(1, food.getId());
        statement.setString(2, food.getType());
        statement.setString(3, food.getName());
        if (statement.executeUpdate() == 1) {
            return food;
        } else {
            return null;
        }
    }

    public Food edit(Food food) throws Exception {
        statement = connection.prepareStatement(
                "UPDATE food SET type=? , name=? WHERE id = ?");
        statement.setString(1, food.getType());
        statement.setString(2, food.getName());
        statement.setLong(3, food.getId());

        if (statement.executeUpdate() == 1) {
            return food;
        } else {
            return null;
        }
    }

    public Food remove(long id) throws Exception {
        Food food = findById(id);

        statement = connection.prepareStatement(
                "DELETE FROM food WHERE id = ?");
        statement.setLong(1,id);

        if (statement.executeUpdate() == 1) {
            return food;
        } else {
            return null;
        }
    }

    public Food findById(long id) throws Exception {
        statement = connection.prepareStatement(
                "SELECT * FROM food WHERE id = ?");
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();
        Food food = new Food(
                resultSet.getString("type"),
                resultSet.getString("name"));
        return food;
    }
    public List<Food> findAll() throws Exception {
        statement = connection.prepareStatement("SELECT * FROM food ORDER BY TYPE , NAME");
        ResultSet resultSet = statement.executeQuery();
        List<Food> foodList = new ArrayList<>();
        while (resultSet.next()) {
            Food food = new Food(
                    resultSet.getString("type"),
                    resultSet.getString("name"));
            foodList.add(food);
        }
        return foodList;
    }


    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
