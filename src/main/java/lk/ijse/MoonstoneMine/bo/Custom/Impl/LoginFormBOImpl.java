package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.Custom.LoginFormBO;
import lk.ijse.MoonstoneMine.dao.Custom.UserDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;

import java.sql.SQLException;

public class LoginFormBOImpl implements LoginFormBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException {
        return userDAO.isExistUser(userName,pw);
    }
}
