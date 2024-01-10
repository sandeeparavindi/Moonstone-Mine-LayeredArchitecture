package lk.ijse.MoonstoneMine.dao.Custom.Impl;

import lk.ijse.MoonstoneMine.dao.Custom.UserDAO;
import lk.ijse.MoonstoneMine.dao.SQLUtil;
import lk.ijse.MoonstoneMine.db.DbConnection;
import lk.ijse.MoonstoneMine.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean add(User entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO user VALUES (?,?,?)",
                entity.getEmail(),
                entity.getName(),
                entity.getPassword());
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return false;
    }

    @Override
    public User search(String id) throws SQLException {
        return null;
    }

    @Override
    public List<User> loadAll() throws SQLException {
        return null;
    }

    @Override
    public String totalUserCount() throws SQLException {
        ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS UserCount FROM user");

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public String getEmail(String email) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT email FROM user WHERE email=?",email);

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public boolean isExistUser(String userName, String pw) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("SELECT password ,name ,email FROM user WHERE name=? AND password=?", userName, pw);

        String schemaUserName = null;
        String schemaPassword = null;
        if (resultSet.next()) {
            schemaPassword = resultSet.getString(1);
            schemaUserName = resultSet.getString(2);
            DbConnection.email = resultSet.getString(3);
        }
        return userName.equals(schemaUserName) && pw.equals(schemaPassword);
    }
}
