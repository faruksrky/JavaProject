package firstrestapi.springrestapi.service;

import firstrestapi.springrestapi.model.Employee;
import firstrestapi.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;


    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }
}
