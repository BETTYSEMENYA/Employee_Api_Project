package com.betty.love2code.springboot.demo.repo;

import com.betty.love2code.springboot.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee , Integer> {

}
