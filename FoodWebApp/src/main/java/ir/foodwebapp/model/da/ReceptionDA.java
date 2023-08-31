package ir.foodwebapp.model.da;

import ir.foodwebapp.model.entity.Reception;
import ir.foodwebapp.model.utils.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//table reception(id number primary key, name nvarchar2(20),family nvarchar2(20),phone_number nvarchar2(11),status number(1),national_code nvarchar2(10),birth_date date);
public class ReceptionDA implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    public ReceptionDA() throws Exception {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public Reception add(Reception reception) throws Exception {
        statement = connection.prepareStatement(
                "SELECT reception_seq.nextval as id FROM DUAL");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        reception.setId(resultSet.getLong("id"));


        reception.setStatus(true);
        statement = connection.prepareStatement(
                "INSERT INTO customer VALUES(?,?, ?, ?, ?, ?, ? )");
        statement.setLong(1, reception.getId());
        statement.setString(2, reception.getName());
        statement.setString(3, reception.getFamily());
        statement.setString(4, reception.getPhoneNumber());
        statement.setBoolean(5, reception.getStatus());
        statement.setString(6, reception.getNationalCode());
        statement.setDate(7, Date.valueOf(reception.getBirthDate()));
        if (statement.executeUpdate() == 1) {
            return reception;
        } else {
            return null;
        }
    }

    public Reception edit(Reception reception) throws Exception {
        statement = connection.prepareStatement(
                "UPDATE customer SET name=?, family=?, phoneNumber=?, status=? , nationalCode=?, birthDate=? WHERE id = ?");
        statement.setString(1, reception.getName());
        statement.setString(2, reception.getFamily());
        statement.setString(3, reception.getPhoneNumber());
        statement.setBoolean(4, reception.getStatus());
        statement.setString(5, reception.getNationalCode());
        statement.setDate(6, Date.valueOf(reception.getBirthDate()));
        if (statement.executeUpdate() == 1) {
            return reception;
        } else {
            return null;
        }
    }

    public Reception remove(long id) throws Exception {
        Reception reception = findById(id);

        statement = connection.prepareStatement(
                "DELETE FROM reception WHERE id = ?");
        statement.setLong(1,id);

        if (statement.executeUpdate() == 1) {
            return reception;
        } else {
            return null;
        }
    }

    public List<Reception> findByNameAndFamily(String name, String family) throws Exception {
        boolean match = true;
        String sqlCommand;
        if (match) {
            sqlCommand = "SELECT * FROM reception WHERE name = ? and family = ? ORDER BY family, name";
        } else {
            name = "%" + name + "%";
            family = "%" + family + "%";

            sqlCommand = "SELECT * FROM reception WHERE name Like ? and family Like ? ORDER BY";
        }

        statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, name);
        statement.setString(2, family);

        ResultSet resultSet = statement.executeQuery();


        List<Reception> receptionList = new ArrayList<>();

        while(resultSet.next()) {
            Reception reception = new Reception(
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getBoolean("status"),
                    resultSet.getString("nationalCode"),
                    resultSet.getDate("birthDate").toLocalDate());
            receptionList.add(reception);

        }

        return receptionList;
    }
    public Reception findByNationalCode(String nationalCode) throws Exception {
        statement = connection.prepareStatement(
                "SELECT * FROM reception WHERE nationalCode = ?");
        statement.setString(1, nationalCode);

        ResultSet resultSet = statement.executeQuery();


        resultSet.next();
        Reception reception = new Reception(
                resultSet.getString("name"),
                resultSet.getString("family"),
                resultSet.getString("phoneNumber"),
                resultSet.getBoolean("status"),
                resultSet.getString("nationalCode"),
                resultSet.getDate("birthDate").toLocalDate());
        return reception;
    }
    public Reception findById(long id) throws Exception {
        statement = connection.prepareStatement(
                "SELECT * FROM reception WHERE id = ?");
        statement.setLong(1, id);

        ResultSet resultSet = statement.executeQuery();


        resultSet.next();
        Reception reception = new Reception(
                resultSet.getString("name"),
                resultSet.getString("family"),
                resultSet.getString("phoneNumber"),
                resultSet.getBoolean("status"),
                resultSet.getString("nationalCode"),
                resultSet.getDate("birthDate").toLocalDate());
        return reception;
    }
    public List<Reception> findAll() throws Exception {
        statement = connection.prepareStatement("SELECT * FROM reception ORDER BY FAMILY, NAME");
        ResultSet resultSet = statement.executeQuery();
        List<Reception> receptionList = new ArrayList<>();
        while (resultSet.next()) {
            Reception reception = new Reception(
                    resultSet.getString("name"),
                    resultSet.getString("family"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getBoolean("status"),
                    resultSet.getString("nationalCode"),
                    resultSet.getDate("birthDate").toLocalDate());
            receptionList.add(reception);
        }
        return receptionList;
    }


    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
