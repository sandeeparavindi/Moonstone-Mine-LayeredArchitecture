package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.ItemBO;
import lk.ijse.MoonstoneMine.dao.Custom.ItemDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.dto.CustomerDto;
import lk.ijse.MoonstoneMine.dto.ItemDto;
import lk.ijse.MoonstoneMine.entity.Customer;
import lk.ijse.MoonstoneMine.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public List<ItemDto> loadAllItems() throws SQLException {
        List<Item> allItems = itemDAO.loadAll();
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (Item entity:allItems) {
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
    public boolean addItem(ItemDto dto) throws SQLException {
        Item entity = new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        );
        return itemDAO.add(entity);
    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return itemDAO.delete(id);
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException {
        Item entity = new Item(
                dto.getCode(),
                dto.getDescription(),
                dto.getUnitPrice(),
                dto.getQtyOnHand()
        );
        return itemDAO.update(entity);
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
}
