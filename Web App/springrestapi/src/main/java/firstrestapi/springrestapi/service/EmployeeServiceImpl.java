package firstrestapi.springrestapi.service;

import firstrestapi.springrestapi.model.Employee;
import firstrestapi.springrestapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public Employee getSingleEmployee(Long id) {
        Optional<Employee> employee = eRepository.findById(id);
        if (employee.isPresent()){

            return employee.get();
        }
        else {
            throw new RuntimeException("Employee is not found for the id: " + id);
        }
    }

    @Override
    public void deleteSingleEmployee(Long id) {
         eRepository.deleteById(id);
    }

    @Override
    public Employee updateSingleEmployee(Employee employee) {
        return eRepository.save(employee);
    }

}
