package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.entity.PlaceOrder;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<PlaceOrder> {
    String generateNextOrderId() throws SQLException;
    String splitOrderId(String currentOrderId);
}
