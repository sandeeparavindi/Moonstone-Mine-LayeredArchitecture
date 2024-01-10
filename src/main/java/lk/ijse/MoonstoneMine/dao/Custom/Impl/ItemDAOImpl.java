package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.ItemDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.dto.ItemDto;
import lk.ijse.MoonstoneMine.entity.Item;
import lk.ijse.MoonstoneMine.view.tm.CartTm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item entity) throws SQLException {
       return SQLUtil.execute("INSERT INTO item VALUES(?, ?, ?, ?)",
               entity.getCode(),
               entity.getDescription(),
               entity.getUnitPrice(),
               entity.getQtyOnHand());
    }

    @Override
    public boolean delete(String code) throws SQLException {
       return SQLUtil.execute("DELETE FROM item WHERE code = ?",code);
    }

    @Override
    public boolean update(Item entity) throws SQLException {
        return SQLUtil.execute("UPDATE item SET description = ?, unit_price = ?, qty_on_hand = ? WHERE code = ?",
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getQtyOnHand(),
                entity.getCode());
    }

    @Override
    public Item search(String id) throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item WHERE code = ?",id);

        Item entity = null;

        if(resultSet.next()) {
            entity = new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
        }
        return entity;
    }

    @Override
    public List<Item> loadAll() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT * FROM item");

        List<Item> itemList = new ArrayList<>();

        while (resultSet.next()) {
            var entity = new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            );
            itemList.add(entity);
        }
        return itemList;
    }

    @Override
    public boolean updateItem(List<CartTm> tmList) throws SQLException {
        for (CartTm cartTm : tmList) {
            if(!updateQty(cartTm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateQty(CartTm cartTm) throws SQLException {
       return SQLUtil.execute("UPDATE item SET qty_on_hand = qty_on_hand - ? WHERE code = ?",
               cartTm.getQty(),
               cartTm.getCode());
    }

    @Override
    public String totalItemCount() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS ItemCount FROM item");

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
}
