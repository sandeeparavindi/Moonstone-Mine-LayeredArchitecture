package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;

import java.sql.SQLException;

public interface AdminFormBO extends SuperBO {
    String totalEmployeeCount() throws SQLException;
    String totalCustomerCount() throws SQLException;
    String totalItemCount() throws SQLException;
    String totalUserCount() throws SQLException;
}
