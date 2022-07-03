package com.test;

import com.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/emp")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        if(service.save(employee))
            return new ResponseEntity<String>("Success saved", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Failed to save", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
    }

    @PutMapping("/emp")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        if(service.update(employee))
            return new ResponseEntity<String>("Success updated", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Data not found", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/emp")
    public ResponseEntity<String> updateEmployeeInfo(@RequestBody Employee employee){
        if(service.update(employee))
            return new ResponseEntity<String>("Success updated", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Data not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/emp")
    public ResponseEntity<String> deleteEmployee(@RequestBody Employee employee){
        if(service.delete(employee))
            return new ResponseEntity<String>("Deleted updated", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Data not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
        if(service.delete(id))
            return new ResponseEntity<String>("Success updated", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Data not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Employee employee = service.getEmployeeById(id);
        if(employee != null)
            return new ResponseEntity<Employee>(employee, HttpStatus.OK);
        else
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/emp/name/{name}")
    public List<Employee> getEmployeeByFirstName(@PathVariable String name){
        return service.getEmployeeByFirstName(name);
    }
    @GetMapping("/emp/salary/{from}/{to}")
    public List<Employee> getEmployeeSalaryBetween(@PathVariable Double from, @PathVariable Double to){
        return service.getEmployeeSalaryBetween(from, to);
    }
}
