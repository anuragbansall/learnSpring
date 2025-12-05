package com.anuragbansall.learnSpring.services;

import com.anuragbansall.learnSpring.dto.DepartmentDto;
import com.anuragbansall.learnSpring.entities.DepartmentEntity;
import com.anuragbansall.learnSpring.entities.EmployeeEntity;
import com.anuragbansall.learnSpring.exceptions.ResourceNotFoundException;
import com.anuragbansall.learnSpring.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

    private DepartmentEntity getDepartmentOrThrow(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department with ID " + id + " not found."));
    }

    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDto.class))
                .toList();
    }

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedEntity, DepartmentDto.class);
    }

    public DepartmentDto updateDepartment(DepartmentDto departmentDto, Long id) {
        DepartmentEntity existing = getDepartmentOrThrow(id);

        DepartmentEntity newEntity = modelMapper.map(departmentDto, DepartmentEntity.class);

        newEntity.setId(existing.getId());
        newEntity.setCreatedAt(existing.getCreatedAt());

        DepartmentEntity updatedEntity = departmentRepository.save(newEntity);

        return modelMapper.map(updatedEntity, DepartmentDto.class);
    }

    public void deleteDepartment(Long id) {
        DepartmentEntity existing = getDepartmentOrThrow(id);
        departmentRepository.delete(existing);
    }

    public DepartmentDto getDepartmentById(Long id) {
        DepartmentEntity entity = getDepartmentOrThrow(id);
        return modelMapper.map(entity, DepartmentDto.class);
    }
}
