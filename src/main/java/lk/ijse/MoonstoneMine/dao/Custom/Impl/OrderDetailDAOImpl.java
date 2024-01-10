package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.OrderDetailDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.entity.PlaceOrder;
import lk.ijse.MoonstoneMine.view.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!saveOrderDetail(orderId, cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException {
        return SQLUtil.execute("INSERT INTO order_detail VALUES(?, ?, ?, ?)",
                orderId,
                cartTm.getCode(),
                cartTm.getQty(),
                cartTm.getUnitPrice());
    }
}
