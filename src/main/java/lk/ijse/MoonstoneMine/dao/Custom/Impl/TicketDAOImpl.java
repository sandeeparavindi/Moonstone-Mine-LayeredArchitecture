package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.TicketDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.dto.TicketDto;
import lk.ijse.MoonstoneMine.entity.Ticket;
import lk.ijse.MoonstoneMine.view.tm.TicketCartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO{
    @Override
    public boolean add(Ticket entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO ticket VALUES(?, ?, ?, ?)",
                entity.getCode(),
                entity.getType(),
                entity.getPrice(),
                entity.getQtyOnHand());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM ticket WHERE code = ?",id);

    }

    @Override
    public boolean update(Ticket entity) throws SQLException {
        return SQLUtil.execute("UPDATE ticket SET type = ?, price = ?, qty_on_hand = ? WHERE code = ?",
                entity.getType(),
                entity.getPrice(),
                entity.getQtyOnHand(),
                entity.getCode());
    }

    @Override
    public Ticket search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM ticket WHERE code = ?",id);

        Ticket entity = null;

        if(resultSet.next()) {
            entity = new Ticket(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return entity;
    }

    @Override
    public List<Ticket> loadAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM ticket");

        List<Ticket> entityList = new ArrayList<>();

        while (resultSet.next()) {
            var entity = new Ticket(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
            entityList.add(entity);
        }
        return entityList;
    }

    @Override
    public boolean updateTicket(List<TicketCartTm> tmList) throws SQLException {
        for ( TicketCartTm cartTm : tmList) {
            if(!updateQty(cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateQty(TicketCartTm cartTm) throws SQLException {
        return SQLUtil.execute("UPDATE ticket SET qty_on_hand = qty_on_hand - ? WHERE code = ?",
                cartTm.getQty(),
                cartTm.getCode());
    }

}
