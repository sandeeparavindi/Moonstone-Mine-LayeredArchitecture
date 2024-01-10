package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.dto.ItemDto;
import lk.ijse.MoonstoneMine.dto.PlaceOrderDto;

import java.sql.SQLException;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    String generateNextOrderId() throws SQLException;
    List<ItemDto> loadAllItem() throws SQLException;
    List<CustomerDto> loadAllCustomer() throws SQLException;
    CustomerDto searchCustomer(String id) throws SQLException;
    ItemDto searchItem(String id) throws SQLException;
    boolean placeOrder(PlaceOrderDto pDto) throws SQLException;
}
