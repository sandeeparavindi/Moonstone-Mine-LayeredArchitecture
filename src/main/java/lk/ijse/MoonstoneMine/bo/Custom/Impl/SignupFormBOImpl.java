package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.SignupFormBO;
import lk.ijse.MoonstoneMine.dao.Custom.UserDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.dto.UserDto;
import lk.ijse.MoonstoneMine.entity.User;

import java.sql.SQLException;

public class SignupFormBOImpl implements SignupFormBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean addUser(UserDto dto) throws SQLException {
        User entity = new User(
                dto.getEmail(),
                dto.getName(),
                dto.getPassword()
        );
        return userDAO.add(entity);
    }

    @Override
    public String getEmail(String email) throws SQLException, ClassNotFoundException {
        return userDAO.getEmail(email);
    }
}
