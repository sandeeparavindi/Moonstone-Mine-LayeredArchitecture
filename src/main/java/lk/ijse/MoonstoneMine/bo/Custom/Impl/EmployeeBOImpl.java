package lk.ijse.MoonstoneMine.bo.Custom.Impl;

import lk.ijse.MoonstoneMine.bo.BOFactory;
import lk.ijse.MoonstoneMine.bo.Custom.EmployeeBO;
import lk.ijse.MoonstoneMine.dao.Custom.EmployeeDAO;
import lk.ijse.MoonstoneMine.dao.DAOFactory;
import lk.ijse.MoonstoneMine.dto.EmployeeDto;
import lk.ijse.MoonstoneMine.entity.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    @Override
    public List<EmployeeDto> getAllEmployees() throws SQLException {

        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        List<EmployeeDto> empDtoList = new ArrayList<>();

        for (Employee entity:allEmployees) {
            empDtoList.add(new EmployeeDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail()
            ));
        }
        return empDtoList;
    }

    @Override
    public boolean addEmployee(EmployeeDto dto) throws SQLException {
        Employee entity = new Employee(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail()
        );
        return employeeDAO.add(entity);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return employeeDAO.delete(id);
    }

    @Override
    public boolean updateEmployee(EmployeeDto dto) throws SQLException {
        Employee entity = new Employee(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail()
        );
        return employeeDAO.update(entity);
    }

    @Override
    public EmployeeDto searchEmployee(String id) throws SQLException {
        Employee entity = employeeDAO.search(id);
        return new EmployeeDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail()
        );
    }
}
