package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.TicketBO;
import lk.ijse.MoonstoneMine.dao.Custom.TicketDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.dto.ItemDto;
import lk.ijse.MoonstoneMine.dto.TicketDto;
import lk.ijse.MoonstoneMine.entity.Item;
import lk.ijse.MoonstoneMine.entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBOImpl implements TicketBO {
    TicketDAO ticketDAO = (TicketDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.TICKET);
    @Override
    public boolean addTicket(TicketDto dto) throws SQLException {
        Ticket entity = new Ticket(
                dto.getCode(),
                dto.getType(),
                dto.getPrice(),
                dto.getQtyOnHand()
        );
        return ticketDAO.add(entity);
    }

    @Override
    public boolean deleteTicket(String id) throws SQLException {
        return ticketDAO.delete(id);
    }

    @Override
    public boolean updateTicket(TicketDto dto) throws SQLException {
        Ticket entity = new Ticket(
                dto.getCode(),
                dto.getType(),
                dto.getPrice(),
                dto.getQtyOnHand()
        );
        return ticketDAO.update(entity);
    }

    @Override
    public TicketDto searchTicket(String id) throws SQLException {
        Ticket entity = ticketDAO.search(id);
        return new TicketDto(
                entity.getCode(),
                entity.getType(),
                entity.getPrice(),
                entity.getQtyOnHand()
        );
    }

    @Override
    public List<TicketDto> loadAllTickets() throws SQLException {
        List<Ticket> allTickets = ticketDAO.loadAll();
        List<TicketDto> ticketDtoList = new ArrayList<>();

        for (Ticket entity: allTickets) {
            ticketDtoList.add(new TicketDto(
                    entity.getCode(),
                    entity.getType(),
                    entity.getPrice(),
                    entity.getQtyOnHand()
            ));
        }
        return ticketDtoList;
    }
}
