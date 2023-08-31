package ir.foodwebapp.model.da;

import ir.foodwebapp.model.entity.Customer;
import ir.foodwebapp.model.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;

    public CustomerDA() throws Exception {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public Customer add(Customer customer) throws Exception {
        statement = connection.prepareStatement(
                "SELECT customer_seq.nextval as id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        customer.setId(resultSet.getLong("id"));

        customer.setStatus(true);
        statement = connection.prepareStatement(
                "INSERT INTO customer VALUES(?,?, ?, ?, ?)");
        statement.setLong(1, customer.getId());
        statement.setString(2, customer.getName());
        statement.setString(3, customer.getFamily());
        statement.setString(4, customer.getPhoneNumber());
        statement.setBoolean(5, customer.getStatus());
        if (statement.executeUpdate() == 1) {
            return customer;
        } else {
            return null;
        }
    }

    public Customer edit(Customer customer) throws Exception {
        statement = connection.prepareStatement(
                "UPDATE customer SET name=?, family=?, phoneNumber=?, status=?, WHERE id = ?");
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getFamily());
        statement.setString(3, customer.getPhoneNumber());
        statement.setBoolean(4, customer.getStatus());
        statement.setLong(6, customer.getId());

        if (statement.executeUpdate() == 1) {
            return customer;
        } else {
            return null;
        }
    }

    public Customer remove(long id) throws Exception {
        Customer customer = findById(id);

        statement = connection.prepareStatement(
                "DELETE FROM customer WHERE id = ?");
        statement.setLong(1,id);

        if (statement.executeUpdate() == 1) {
            return customer;
        } else {
            return null;
        }
    }

    public List<Customer> findByNameAndFamily(String name, String family) throws Exception {
        boolean match = true;
        String sqlCommand;
        if (match) {
            sqlCommand = "SELECT * FROM customer WHERE name = ? and family = ? ORDER BY family, name";
        } else {
            name = "%" + name + "%";
            family = "%" + family + "%";

            sqlCommand = "SELECT * FROM customer WHERE name Like ? and family Like ? ORDER BY";
        }

        statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, name);
        statement.setString(2, family);

        ResultSet resultSet = statement.executeQuery();


        List<Customer> customerList = new ArrayList<>();

        while(resultSet.next()) {
            Customer customer = new Customer(
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getBoolean("status"));
            customerList.add(customer);
        }

        return customerList;
    }

    public Customer findById(long id) throws Exception {
        statement = connection.prepareStatement(
                "SELECT * FROM customer WHERE id = ?");
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();


        resultSet.next();
        Customer customer = new Customer(
                resultSet.getString("name"),
                resultSet.getString("family"),
                resultSet.getString("phoneNumber"),
                resultSet.getBoolean("status"));
        return customer;
    }

    public List<Customer> findAll() throws Exception {
        statement = connection.prepareStatement("SELECT * FROM Customer ORDER BY FAMILY, NAME");
        ResultSet resultSet = statement.executeQuery();
        List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer(
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getBoolean("status"));
            customerList.add(customer);
        }
        return customerList;
    }


    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
