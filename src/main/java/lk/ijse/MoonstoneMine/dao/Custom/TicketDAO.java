package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.entity.Ticket;
import lk.ijse.MoonstoneMine.view.tm.TicketCartTm;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO extends CrudDAO<Ticket> {
    boolean updateTicket(List<TicketCartTm> tmList) throws SQLException;
    boolean updateQty(TicketCartTm cartTm) throws SQLException;

}
