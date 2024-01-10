package lk.ijse.MoonstoneMine.bo.Custom;

import lk.ijse.MoonstoneMine.bo.SuperBO;
import lk.ijse.MoonstoneMine.dto.EmployeeDto;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeBO extends SuperBO {
    List<EmployeeDto> getAllEmployees() throws SQLException;
    boolean addEmployee(final EmployeeDto dto) throws SQLException ;
    boolean deleteEmployee(String id) throws SQLException;
    boolean updateEmployee(final EmployeeDto dto) throws SQLException;
    EmployeeDto searchEmployee(String id) throws SQLException;
}
