package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.entity.TicketBooking;

import java.sql.SQLException;

public interface BookingDAO extends CrudDAO<TicketBooking> {
    String generateNextBookingId() throws SQLException;
    String splitBookingId(String currentBookingId);
}
