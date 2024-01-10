package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.OrderDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.entity.PlaceOrder;

import java.sql.*;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean add(PlaceOrder entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO orders VALUES(?, ?, ?)",
                entity.getOrderId(),
                entity.getCusId(),
                entity.getDate());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(PlaceOrder entity) throws SQLException {
        return false;
    }

    @Override
    public PlaceOrder search(String id) throws SQLException {
        return null;
    }

    @Override
    public List<PlaceOrder> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String generateNextOrderId() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1");

        String currentOrderId = null;

        if (resultSet.next()) {
            currentOrderId = resultSet.getString(1);
            return splitOrderId(currentOrderId);
        }
        return splitOrderId(null);
    }

    @Override
    public String splitOrderId(String currentOrderId) {
        if (currentOrderId != null) {
            String[] split = currentOrderId.split("O");
            int id = Integer.parseInt(split[1]);
            id++;
            return "O00" + id;
        }
        return "O001";
    }
}
