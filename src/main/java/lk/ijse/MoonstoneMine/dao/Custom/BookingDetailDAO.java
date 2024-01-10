package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.SuperDAO;
import lk.ijse.MoonstoneMine.view.tm.TicketCartTm;

import java.sql.SQLException;
import java.util.List;

public interface BookingDetailDAO extends SuperDAO {
    boolean saveBookingDetail(String bookingId, List<TicketCartTm> tmList) throws SQLException;
    boolean saveBookingDetail(String bookingId, TicketCartTm cartTm) throws SQLException;
}
