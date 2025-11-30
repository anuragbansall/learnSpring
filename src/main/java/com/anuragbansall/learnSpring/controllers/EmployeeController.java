package com.anuragbansall.learnSpring.controllers;

import com.anuragbansall.learnSpring.dto.EmployeeDto;
import com.anuragbansall.learnSpring.entities.EmployeeEntity;
import com.anuragbansall.learnSpring.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeDto.getName());
        employeeEntity.setEmail(employeeDto.getEmail());
        employeeEntity.setAge(employeeDto.getAge());
        employeeEntity.setDateOfJoining(employeeDto.getDateOfJoining());
        employeeEntity.setIsActive(employeeDto.getIsActive());
        return  employeeRepository.save(employeeEntity);
    }
}
