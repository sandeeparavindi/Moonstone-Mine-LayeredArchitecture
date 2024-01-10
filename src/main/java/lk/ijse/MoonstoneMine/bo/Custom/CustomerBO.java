package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO extends SuperBO {
    List<CustomerDto> getAllCustomers() throws SQLException;
    boolean addCustomer(final CustomerDto dto) throws SQLException ;
    boolean deleteCustomer(String id) throws SQLException;
    boolean updateCustomer(final CustomerDto dto) throws SQLException;
    CustomerDto searchCustomer(String id) throws SQLException;
}
