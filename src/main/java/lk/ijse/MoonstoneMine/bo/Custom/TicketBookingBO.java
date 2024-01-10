package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.dto.TicketBookingDto;
import lk.ijse.MoonstoneMine.dto.TicketDto;

import java.sql.SQLException;
import java.util.List;

public interface TicketBookingBO extends SuperBO {
    String generateNextBookingId() throws SQLException;
    List<TicketDto> loadAllTickets() throws SQLException;
    List<CustomerDto> loadAllCustomers() throws SQLException;
    TicketDto searchTicket(String id) throws SQLException;
    CustomerDto searchCustomer(String id) throws SQLException;
    boolean ticketBooking(TicketBookingDto pDto) throws SQLException;
}
