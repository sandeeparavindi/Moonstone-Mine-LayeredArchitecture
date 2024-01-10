package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.UserDto;

import java.sql.SQLException;

public interface SignupFormBO extends SuperBO {
    boolean addUser(final UserDto dto) throws SQLException;
    String getEmail(String email) throws SQLException, ClassNotFoundException;
}
