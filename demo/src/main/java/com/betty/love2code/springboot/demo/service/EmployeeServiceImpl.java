package com.betty.love2code.springboot.demo.service;


import com.betty.love2code.springboot.demo.repo.EmployeeRepo;
import com.betty.love2code.springboot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl( EmployeeRepo employeeRepo){
        this.employeeRepo=employeeRepo;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepo.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepo.deleteById(theId);
    }
}
