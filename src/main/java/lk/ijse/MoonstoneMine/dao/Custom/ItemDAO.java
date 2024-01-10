package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.entity.Item;
import lk.ijse.MoonstoneMine.view.tm.CartTm;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {
    boolean updateItem(List<CartTm> tmList) throws SQLException;
    boolean updateQty(CartTm cartTm) throws SQLException;
    String totalItemCount() throws SQLException;
}
