package com.anuragbansall.learnSpring.controllers;

import com.anuragbansall.learnSpring.dto.EmployeeDto;
import com.anuragbansall.learnSpring.exceptions.ResourceNotFoundException;
import com.anuragbansall.learnSpring.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(employee);
    }

    // Exception handler for NoSuchElementException
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleEmployeeNotFoundException(NoSuchElementException e) {
//        return new ResponseEntity<>("Employee not found: " + e.getMessage(), HttpStatus.NOT_FOUND);
//    } // It is not recommended to have exception handlers in controller classes. Instead, use @ControllerAdvice for global exception handling in separate classes.

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employee) {
        EmployeeDto createdEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(createdEmployee, org.springframework.http.HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDto employee) {
        EmployeeDto updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<EmployeeDto> patchEmployee(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        EmployeeDto patchedEmployee = employeeService.patchEmployee(id, updates);
        if (patchedEmployee != null) {
            return ResponseEntity.ok(patchedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
