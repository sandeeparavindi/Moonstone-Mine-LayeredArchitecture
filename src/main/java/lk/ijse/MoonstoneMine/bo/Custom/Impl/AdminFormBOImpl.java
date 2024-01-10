package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.AdminFormBO;
import lk.ijse.MoonstoneMine.dao.Custom.CustomerDAO;
import lk.ijse.MoonstoneMine.dao.Custom.EmployeeDAO;
import lk.ijse.MoonstoneMine.dao.Custom.ItemDAO;
import lk.ijse.MoonstoneMine.dao.Custom.UserDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;

import java.sql.SQLException;

public class AdminFormBOImpl implements AdminFormBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public String totalEmployeeCount() throws SQLException {
        return employeeDAO.totalEmployeeCount();
    }

    @Override
    public String totalCustomerCount() throws SQLException {
        return customerDAO.totalCustomerCount();
    }

    @Override
    public String totalItemCount() throws SQLException {
        return itemDAO.totalItemCount();
    }

    @Override
    public String totalUserCount() throws SQLException {
        return userDAO.totalUserCount();
    }
}
