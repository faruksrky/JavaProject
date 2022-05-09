package firstrestapi.springrestapi.service;

import firstrestapi.springrestapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

     List<Employee> getEmployees();

     Employee saveEmployee(Employee employee);

     Employee getSingleEmployee(Long id);

     void deleteSingleEmployee (Long id);

     Employee updateSingleEmployee(Employee employee);
}
