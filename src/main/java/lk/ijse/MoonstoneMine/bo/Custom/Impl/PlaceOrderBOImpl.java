package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.PlaceOrderBO;
import lk.ijse.MoonstoneMine.dao.Custom.CustomerDAO;
import lk.ijse.MoonstoneMine.dao.Custom.ItemDAO;
import lk.ijse.MoonstoneMine.dao.Custom.OrderDAO;
import lk.ijse.MoonstoneMine.dao.Custom.OrderDetailDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.dto.ItemDto;
import lk.ijse.MoonstoneMine.dto.PlaceOrderDto;
import lk.ijse.MoonstoneMine.entity.Customer;
import lk.ijse.MoonstoneMine.entity.Item;
import lk.ijse.MoonstoneMine.entity.PlaceOrder;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);
    @Override
    public String generateNextOrderId() throws SQLException {
        return orderDAO.generateNextOrderId();
    }

    @Override
    public List<ItemDto> loadAllItem() throws SQLException {

        List<Item> itemList = itemDAO.loadAll();
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Item entity:itemList) {
            itemDtoList.add(new ItemDto(
                    entity.getCode(),
                    entity.getDescription(),
                    entity.getUnitPrice(),
                    entity.getQtyOnHand()
            ));
        }
        return itemDtoList;
    }

    @Override
    public List<CustomerDto> loadAllCustomer() throws SQLException {
        List<Customer> customers = customerDAO.loadAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer entity:customers) {
            customerDtoList.add(new CustomerDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail()
            ));
        }
        return customerDtoList;
    }

    @Override
    public CustomerDto searchCustomer(String id) throws SQLException {
        Customer entity = customerDAO.search(id);
        return new CustomerDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail()
        );
    }

    @Override
    public ItemDto searchItem(String id) throws SQLException {
        Item entity = itemDAO.search(id);
        return new ItemDto(
                entity.getCode(),
                entity.getDescription(),
                entity.getUnitPrice(),
                entity.getQtyOnHand()
        );
    }

    @Override
    public boolean placeOrder(PlaceOrderDto pDto) throws SQLException {

        PlaceOrder entity = new PlaceOrder(
                pDto.getOrderId(),
                pDto.getCusId(),
                pDto.getDate(),
                pDto.getTmList()
        );

        boolean result = false;
        Connection connection = null;

        connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        boolean isOrderSaved = orderDAO.add(entity);
        if (isOrderSaved) {
            boolean isUpdated = itemDAO.updateItem(entity.getTmList());
            if (isUpdated) {
                boolean isOrderDetailSaved = orderDetailDAO.saveOrderDetail(entity.getOrderId(), entity.getTmList());
                if (isOrderDetailSaved) {
                    connection.commit();
                    connection.setAutoCommit(true);
                    result = true;
                }
                else {
                    connection.rollback();
                    connection.setAutoCommit(true);
                }
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
            }
        } else {
            connection.rollback();
            connection.setAutoCommit(true);
        }
        return result;
    }
}
