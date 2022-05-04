package firstrestapi.springrestapi.service;

import firstrestapi.springrestapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

     List<Employee> getEmployees();
}
