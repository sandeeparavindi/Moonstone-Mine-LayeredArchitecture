package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {
    List<ItemDto> loadAllItems() throws SQLException;
    boolean addItem(final ItemDto dto) throws SQLException ;
    boolean deleteItem(String id) throws SQLException;
    boolean updateItem(final ItemDto dto) throws SQLException;

    ItemDto searchItem(String id) throws SQLException;
}
