package com.anuragbansall.learnSpring.services;

import com.anuragbansall.learnSpring.dto.EmployeeDto;
import com.anuragbansall.learnSpring.entities.EmployeeEntity;
import com.anuragbansall.learnSpring.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .toList();
    }

    public EmployeeDto getEmployeeById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public EmployeeDto createEmployee(EmployeeDto employee) {
        EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

        public EmployeeDto updateEmployee(Long id, EmployeeDto employee) {
        EmployeeEntity employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
        employeeEntity.setId(id); // Ensure the ID is set for updating
        EmployeeEntity updatedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    public boolean isEmployeeExists(Long id) {
        return employeeRepository.existsById(id);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto patchEmployee(Long id, Map<String, Object> updates) {
      if (!employeeRepository.existsById(id)) {
          return null;
      }

      EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.getRequiredField(EmployeeEntity.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employeeEntity, value);
        });

        employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }
}
