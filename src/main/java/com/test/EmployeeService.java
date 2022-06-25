package com.test;

import com.test.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public boolean save(Employee employee) {
        Integer id = employee.getId();
        if(id !=null && repository.existsById(id))
            return false;
        repository.save(employee);
        return true;
    }

    public List<Employee> getAllEmployee() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return repository.findById(id).get();
    }

    public List<Employee> getEmployeeByFirstName(String name) {
        return repository.findByFirstNameIgnoreCase(name);
    }

    public List<Employee> getEmployeeSalaryBetween(Double from, Double to) {
        return repository.findBySalaryBetween(from, to);
    }
}
