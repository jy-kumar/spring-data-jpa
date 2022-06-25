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
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
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
