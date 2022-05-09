package firstrestapi.springrestapi.controller;

import firstrestapi.springrestapi.model.Employee;
import firstrestapi.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@Controller @Controller + @ResponseBody combine edilmesi sonucu @RestController oluşturulmultur.
// Bu sebeple Restful servislerde @RestController kullanılması daha uygundur. Eğer @RestController kullanılırsa her request ardından ResponseBody yazmaya gerek yoktur.

public class EmployeeController {

    @Autowired
    private EmployeeService eService;

   // @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @GetMapping("/employees") // RequestMapping içerisinde yer alan methodlar tek metod altında birleştirilmiştir.
    //@ResponseBody Controller kullanılırsa ResponseBody kullanılmak zorundadır

    /*public List<Employee> getEmployees() {
        return eService.getEmployees();
        // Genel olarak kullanmak için bu method yeterlidir ancak
        //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    }*/

    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.OK kullanılacktır
    public ResponseEntity<List<Employee>> getEmployees(){

        return new ResponseEntity<List<Employee>>(eService.getEmployees(), HttpStatus.OK);
    }

    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.OK kullanılacaktır

    @GetMapping ("/employees/{id}")
    //localhost:8080/employees/11 (11 numaralı employee bilgileri)
    /*public Employee getEmployee(@PathVariable("id") Long id){
        return eService.getSingleEmployee(id);
    }
     */
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<Employee>(eService.getSingleEmployee(id), HttpStatus.OK);
    }

    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.Created kullanılacaktır
    @PostMapping("/employees")
    /*public Employee craateEmployee(@RequestBody Employee employee){
        return eService.saveEmployee(employee);
    }
    */
    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.Created kullanılacaktır
    public ResponseEntity<Employee> craateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(eService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.OK kullanılacaktır
   /* public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return eService.updateSingleEmployee(employee);
    }
    */

    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return new ResponseEntity<Employee>(eService.updateSingleEmployee(employee), HttpStatus.OK);
    }


    @DeleteMapping ("/employees") // //localhost:8080/employees?id=11 (11 numaralı employee bilgileri)
    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.NoContent kullanılacaktır
    /*public void deleteEmployee(@RequestParam ("id") Long id){
        eService.deleteSingleEmployee(id);
    }
    */
    //Http Status kodlarını client tarafında farklı görmek için ResponseEntity objesi kullanmak faydalı olacaktır.
    // HTTPStatus.NoContent kullanılacaktır. NoContent ifadesi DB tarafından da datayı silmektedir.
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam ("id") Long id){
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

}
