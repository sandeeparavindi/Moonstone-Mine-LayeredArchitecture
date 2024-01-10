package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO extends CrudDAO<Customer> {
    String totalCustomerCount() throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;
}
