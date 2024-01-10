package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.BookingDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.entity.TicketBooking;

import java.sql.*;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    @Override
    public boolean add(TicketBooking entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO booking VALUES(?, ?, ?)",
                entity.getBookingId(),
                entity.getCusId(),
                entity.getDate());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TicketBooking entity) throws SQLException {
        return false;
    }

    @Override
    public TicketBooking search(String id) throws SQLException {
        return null;
    }

    @Override
    public List<TicketBooking> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateNextBookingId() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT booking_id FROM booking ORDER BY booking_id DESC LIMIT 1");

        String currentBookingId = null;

        if (resultSet.next()) {
            currentBookingId = resultSet.getString(1);
            return splitBookingId(currentBookingId);
        }
        return splitBookingId(null);
    }

    @Override
    public String splitBookingId(String currentBookingId) {
        if (currentBookingId != null) {
            String[] split = currentBookingId.split("O");
            int id = Integer.parseInt(split[1]);
            id++;
            return "O00" + id;
        }
        return "O001";
    }
}
