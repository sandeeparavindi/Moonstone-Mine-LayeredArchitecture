package lk.ijse.MoonstoneMine.dao;

import lk.ijse.MoonstoneMine.dao.Custom.BookingDetailDAO;
import lk.ijse.MoonstoneMine.dao.Custom.Impl.*;
import lk.ijse.MoonstoneMine.dao.Custom.OrderDetailDAO;

public class DAOFactory {

    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null)? daoFactory =new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER, ITEM, EMPLOYEE,TICKET,USER,ORDER,ORDER_DETAIL,BOOKING,BOOKING_DETAIL

    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case TICKET:
                return new TicketDAOImpl();
            case USER:
                return new UserDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case BOOKING:
                return new BookingDAOImpl();
            case BOOKING_DETAIL:
                return new BookingDetailDAOImpl();
            default:
                return null;
        }
    }
}
