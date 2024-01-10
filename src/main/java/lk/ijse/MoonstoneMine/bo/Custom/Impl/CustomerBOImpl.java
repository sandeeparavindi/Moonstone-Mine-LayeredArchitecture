package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.CustomerBO;
import lk.ijse.MoonstoneMine.dao.Custom.CustomerDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {

        List<Customer> allCustomers = customerDAO.getAllCustomers();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer entity: allCustomers) {
            customerDtoList.
                    add(new CustomerDto(
                            entity.getId(),
                            entity.getName(),
                            entity.getAddress(),
                            entity.getPhone(),
                            entity.getEmail()
                    ));
        }
        return customerDtoList;
    }

    @Override
    public boolean addCustomer(CustomerDto dto) throws SQLException {
       Customer entity = new Customer(
               dto.getId(),
               dto.getName(),
               dto.getAddress(),
               dto.getPhone(),
               dto.getEmail()
       );
        return customerDAO.add(entity);
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        Customer entity = new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail()
        );
        return customerDAO.update(entity);
    }

    @Override
    public CustomerDto searchCustomer(String id) throws SQLException {
        Customer entity = customerDAO.search(id);
        return new CustomerDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail()
        );
    }
}
