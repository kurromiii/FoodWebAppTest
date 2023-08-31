package ir.foodwebapp.model.da;

import ir.foodwebapp.model.entity.Order;
import ir.foodwebapp.model.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class OrderDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public OrderDA() throws Exception {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public Order add(Order order) throws Exception {
        statement = connection.prepareStatement("INSERT INTO order VALUES (?,?,?,?)");
        statement.setLong(1, order.getCustomerId());
        statement.setLong(2, order.getFoodId());
        statement.setTimestamp(3, Timestamp.valueOf(order.getOrderTime()));
        statement.setInt(4, order.getTableNumber());

        if (statement.executeUpdate() == 1) {
            return order;
        } else {
            return null;
        }
    }

    public Order edit(Order order) throws Exception {
        statement = connection.prepareStatement(
                "UPDATE orders SET customer_id=? , food_id=?,order_time=?,table_number=? WHERE id = ?");
        statement.setLong(1, order.getCustomerId());
        statement.setLong(2, order.getFoodId());
        statement.setTimestamp(3, Timestamp.valueOf(order.getOrderTime()));
        statement.setInt(4, order.getTableNumber());
        statement.setLong(5, order.getId());

        if (statement.executeUpdate() == 1) {
            return order;
        } else {
            return null;
        }
    }

    public Order remove(long id) throws Exception {
        Order order = findById(id);

        statement = connection.prepareStatement(
                "DELETE FROM orders WHERE id = ?");
        statement.setLong(1, id);

        if (statement.executeUpdate() == 1) {
            return order;
        } else {
            return null;
        }
    }

    public Order findById(long id) throws Exception {
        statement = connection.prepareStatement(
                "SELECT * FROM orders WHERE id = ?");
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();

        resultSet.next();
        Order order = new Order()
                .setId(resultSet.getLong("id"))
                .setCustomerId(resultSet.getLong("customer_id"))
                .setFoodId(resultSet.getLong("food_id"))
                .setOrderTime(resultSet.getTimestamp("order_time").toLocalDateTime())
                .setTableNumber(resultSet.getInt("table_number"));
        return order;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
