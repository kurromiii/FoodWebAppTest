package ir.foodwebapp.model.da;

import ir.foodwebapp.model.entity.OrderView;
import ir.foodwebapp.model.utils.ConnectionProvider;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderViewDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public OrderViewDA() throws Exception {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }
    //customer
    public List<OrderView> findByNameAndFamily(String customerName, String customerFamily) throws Exception {
        boolean match = true;
        String sqlCommand;
        if (match) {
            sqlCommand = "SELECT * FROM order_view WHERE customer_firstname = ? and customer_lastname = ? ORDER BY customer_lastname, customer_firstname";
        } else {
            customerName = "%" + customerName + "%";
            customerFamily = "%" + customerFamily + "%";

            sqlCommand = "SELECT * FROM order_view WHERE customer_firstname Like ? and customer_lastname Like ? ORDER BY";
        }

        statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, customerName);
        statement.setString(2, customerFamily);

        ResultSet resultSet = statement.executeQuery();


        List<OrderView> orderViewList = new ArrayList<>();

        while(resultSet.next()) {
            OrderView orderView = new OrderView(
                    resultSet.getString("customerName"),
                    resultSet.getString("customerFamily"),
                    resultSet.getString("customerPhone"));
            orderViewList.add(orderView);
        }

        return orderViewList;
    }
    //food
    public List<OrderView> findByTypeAndName(String foodType, String foodName) throws Exception {
        boolean match = true;
        String sqlCommand;
        if (match) {
            sqlCommand = "SELECT * FROM order_view WHERE foodType = ? and foodName = ? ORDER BY foodType, foodName";
        } else {
           foodType  = "%" + foodType + "%";
            foodName = "%" + foodName + "%";

            sqlCommand = "SELECT * FROM order_view WHERE foodType Like ? and foodName Like ? ORDER BY";
        }

        statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, foodType);
        statement.setString(2, foodName);

        ResultSet resultSet = statement.executeQuery();


        List<OrderView> orderViewList = new ArrayList<>();

        while(resultSet.next()) {
            OrderView orderView = new OrderView(
                    resultSet.getString("foodType"),
                    resultSet.getString("foodName"));
            orderViewList.add(orderView);
        }

        return orderViewList;
    }
    //time
    public List<OrderView> findByDate(LocalDate date) throws SQLException {
        statement = connection.prepareStatement("SELECT order_time FROM orders ORDER BY ");
        statement.setDate(1, Date.valueOf(date));
        ResultSet resultSet = statement.executeQuery();
        List<OrderView> orderViewList = new ArrayList<>();


        while(resultSet.next()) {
            OrderView orderView = new OrderView(
                  resultSet.getTimestamp("orderTime").toLocalDateTime());
            orderViewList.add(orderView);
        }

        return orderViewList;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
