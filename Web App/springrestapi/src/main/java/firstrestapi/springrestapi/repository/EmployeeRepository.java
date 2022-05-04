package firstrestapi.springrestapi.repository;

import firstrestapi.springrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
