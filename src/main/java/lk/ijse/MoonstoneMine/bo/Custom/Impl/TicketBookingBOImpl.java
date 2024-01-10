package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.TicketBookingBO;
import lk.ijse.MoonstoneMine.dao.Custom.BookingDAO;
import lk.ijse.MoonstoneMine.dao.Custom.BookingDetailDAO;
import lk.ijse.MoonstoneMine.dao.Custom.CustomerDAO;
import lk.ijse.MoonstoneMine.dao.Custom.TicketDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.dto.TicketBookingDto;
import lk.ijse.MoonstoneMine.dto.TicketDto;
import lk.ijse.MoonstoneMine.entity.Customer;
import lk.ijse.MoonstoneMine.entity.Ticket;
import lk.ijse.MoonstoneMine.entity.TicketBooking;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBookingBOImpl implements TicketBookingBO {
    TicketDAO ticketDAO = (TicketDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);
    BookingDetailDAO bookingDetailDAO = (BookingDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING_DETAIL);

    @Override
    public String generateNextBookingId() throws SQLException {
        return bookingDAO.generateNextBookingId();
    }

    @Override
    public List<TicketDto> loadAllTickets() throws SQLException {
        List<Ticket> tickets = ticketDAO.loadAll();
        List<TicketDto> ticketDtoList = new ArrayList<>();

        for (Ticket entity : tickets) {
            ticketDtoList.add(new TicketDto(
                    entity.getCode(),
                    entity.getType(),
                    entity.getPrice(),
                    entity.getQtyOnHand()
            ));
        }
        return ticketDtoList;
    }

    @Override
    public List<CustomerDto> loadAllCustomers() throws SQLException {
        List<Customer> customers = customerDAO.loadAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer entity : customers) {
            customerDtoList.add(new CustomerDto(
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
    public TicketDto searchTicket(String id) throws SQLException {
        Ticket entity = ticketDAO.search(id);
        return new TicketDto(
                entity.getCode(),
                entity.getType(),
                entity.getPrice(),
                entity.getQtyOnHand()
        );
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

    @Override
    public boolean ticketBooking(TicketBookingDto pDto) throws SQLException {

        TicketBooking entity = new TicketBooking(
                pDto.getBookingId(),
                pDto.getCusId(),
                pDto.getDate(),
                pDto.getTmList()
        );

        boolean result = false;
        Connection connection = null;

        connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isBookingSaved = bookingDAO.add(entity);
        if (isBookingSaved) {
            boolean isUpdated = ticketDAO.updateTicket(entity.getTmList());
            if (isUpdated) {
                boolean isBookingDetailSaved = bookingDetailDAO.saveBookingDetail(entity.getBookingId(), entity.getTmList());
                if (isBookingDetailSaved) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    result = true;
                } else {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } else {
            connection.rollback();
            connection.setAutoCommit(true);
        }
        return result;
    }
}
