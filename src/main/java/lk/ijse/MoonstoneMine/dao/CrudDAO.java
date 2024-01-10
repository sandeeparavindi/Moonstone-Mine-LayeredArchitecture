package lk.ijse.MoonstoneMine.dao;

import lk.ijse.MoonstoneMine.dto.CustomerDto;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean add(final T entity) throws SQLException ;
    boolean delete(String id) throws SQLException;

    boolean update(final T entity) throws SQLException;

    T search(String id) throws SQLException;

    List<T> loadAll() throws SQLException;
}
