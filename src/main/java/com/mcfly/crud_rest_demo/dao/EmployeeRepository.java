package com.mcfly.crud_rest_demo.dao;

import com.mcfly.crud_rest_demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
