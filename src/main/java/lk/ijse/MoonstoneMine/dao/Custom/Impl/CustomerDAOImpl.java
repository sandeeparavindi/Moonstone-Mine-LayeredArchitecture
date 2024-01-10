package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.CustomerDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO customer VALUES(?, ?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE id = ?", id);

    }

    @Override
    public boolean update(Customer entity) throws SQLException {
       return SQLUtil.execute("UPDATE customer SET name = ?, address = ?, phone = ?, email = ? WHERE id = ?",
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getId());
    }

    @Override
    public Customer search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer WHERE id = ?", id);

        Customer entity = null;

        if(resultSet.next()) {
            //String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);

            entity = new Customer(id, name, address, phone, email);
        }

        return entity;
    }

    @Override
    public List loadAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer");


        List<Customer> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return cusList;
    }

    @Override
    public String totalCustomerCount() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS CustomerCount FROM customer");

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;

    }

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM customer");

        List<Customer> entityList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);


            var entity = new Customer(id,name,address,phone,email);
            entityList.add(entity);
        }
        return entityList;
    }
}
