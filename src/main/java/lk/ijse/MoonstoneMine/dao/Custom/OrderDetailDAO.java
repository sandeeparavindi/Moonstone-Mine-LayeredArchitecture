package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.dao.SuperDAO;
import lk.ijse.MoonstoneMine.entity.PlaceOrder;
import lk.ijse.MoonstoneMine.view.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO extends SuperDAO {
    boolean saveOrderDetail(String orderId, List<CartTm> tmList) throws SQLException;
    boolean saveOrderDetail(String orderId, CartTm cartTm) throws SQLException;

}
