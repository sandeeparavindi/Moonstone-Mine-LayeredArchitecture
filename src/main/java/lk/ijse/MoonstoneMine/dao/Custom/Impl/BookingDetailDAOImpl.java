package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.BookingDAO;
import lk.ijse.MoonstoneMine.dao.Custom.BookingDetailDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.view.tm.TicketCartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class BookingDetailDAOImpl implements BookingDetailDAO {
    @Override
    public boolean saveBookingDetail(String bookingId, List<TicketCartTm> tmList) throws SQLException {
        for (TicketCartTm cartTm : tmList) {
            if(!saveBookingDetail(bookingId, cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveBookingDetail(String bookingId, TicketCartTm cartTm) throws SQLException {
        return SQLUtil.execute("INSERT INTO booking_detail VALUES(?, ?, ?, ?)",
                bookingId,
                cartTm.getCode(),
                cartTm.getQty(),
                cartTm.getPrice());
    }
}
