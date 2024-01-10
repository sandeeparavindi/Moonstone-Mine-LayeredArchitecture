package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.EmployeeDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.dto.EmployeeDto;
import lk.ijse.MoonstoneMine.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public boolean add(Employee entity) throws SQLException {
       return SQLUtil.execute("INSERT INTO employee VALUES(?, ?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM employee WHERE e_id = ?",id);
    }

    @Override
    public boolean update(Employee entity) throws SQLException {
       return SQLUtil.execute("UPDATE employee SET name = ?, address = ?, phone = ?, email = ? WHERE e_id = ?",
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getId());
    }

    @Override
    public Employee search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee WHERE e_id = ?",id);

        Employee entity = null;

        if(resultSet.next()) {
            //String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);

            entity = new Employee(id, name, address, phone, email);
        }

        return entity;
    }

    @Override
    public List<Employee> loadAll() throws SQLException {
       ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");

        List<Employee> empList = new ArrayList<>();

        while (resultSet.next()) {
            empList.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return empList;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM employee");

        List<Employee> empList = new ArrayList<>();

        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);


            var entity = new Employee(id,name,address,phone,email);
            empList.add(entity);
        }
        return empList;
    }

    @Override
    public String totalEmployeeCount() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS EmployeeCount FROM employee");
        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

}
