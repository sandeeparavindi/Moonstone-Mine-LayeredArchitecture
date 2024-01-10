package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.TicketDto;

import java.sql.SQLException;
import java.util.List;

public interface TicketBO extends SuperBO {
    boolean addTicket(final TicketDto dto) throws SQLException;
    boolean deleteTicket(String id) throws SQLException;
    boolean updateTicket(final TicketDto dto) throws SQLException;
    TicketDto searchTicket(String id) throws SQLException;
    List<TicketDto> loadAllTickets() throws SQLException;
}
