package lk.ijse.MoonstoneMine.dao.Custom;

import lk.ijse.MoonstoneMine.dao.CrudDAO;
import lk.ijse.MoonstoneMine.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User> {
    String totalUserCount() throws SQLException;
    String getEmail(String email) throws SQLException, ClassNotFoundException;
    boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException;
}
