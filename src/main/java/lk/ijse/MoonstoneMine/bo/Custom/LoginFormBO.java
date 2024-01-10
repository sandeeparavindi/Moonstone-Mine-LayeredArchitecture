package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;

import java.sql.SQLException;

public interface LoginFormBO extends SuperBO {
    boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException;
}
