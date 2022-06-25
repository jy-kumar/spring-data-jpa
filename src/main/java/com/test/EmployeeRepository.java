package com.test;

import com.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstNameIgnoreCase(String name);
    List<Employee> findBySalaryBetween(Double from, Double to);
}
