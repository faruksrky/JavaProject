package firstrestapi.springrestapi.controller;

import firstrestapi.springrestapi.model.Employee;
import firstrestapi.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller @Controller + @ResponseBody combine edilmesi sonucu @RestController oluşturulmultur.
// Bu sebeple Restful servislerde @RestController kullanılması daha uygundur. Eğer @RestController kullanılırsa her request ardından ResponseBody yazmaya gerek yoktur.

public class EmployeeController {

    @Autowired
    private EmployeeService eService;

   // @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/employees") // RequestMapping içerisinde yer alan methodlar tek metod altında birleştirilmiştir.
    //@ResponseBody Controller kullanılırsa ResponseBody kullanılmak zorundadır
    public List<Employee> getEmployees() {
        return eService.getEmployees();
    }

    @GetMapping ("/employees/{id}")
    //localhost:8080/employees/11 (11 numaralı employee bilgileri)
    public String getEmployee(@PathVariable("id") Long id){
        return "fetching the employee details for id " + id;
    }

    @PostMapping("/employees")
    public String craateEmployee(@RequestBody Employee employee){
        return "saving the employee details to the DB " + employee ;
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        System.out.println("updating the employee data for the id " + id);
        return employee;
    }

    @DeleteMapping ("/employees") // //localhost:8080/employees?id=11 (11 numaralı employee bilgileri)
    public String deleteEmployee(@RequestParam ("id") Long id){
        return "deleting the employee details for id " + id;
    }

}
