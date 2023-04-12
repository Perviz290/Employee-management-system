package com.neizu.employeemanager.service;

import com.neizu.employeemanager.dto.EmployeeDTO;
import com.neizu.employeemanager.entity.Employee;
import com.neizu.employeemanager.exception.IdNotFoundException;
import com.neizu.employeemanager.repository.EmployeeRepo;
import com.neizu.employeemanager.service.interfaces.EmployeeServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new IdNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public Employee create(EmployeeDTO dto) {
        Employee employee= Employee.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .jobTitle(dto.getJobTitle())
                .phone(dto.getPhone())
                .employeeCode(UUID.randomUUID().toString())
                .build();
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Employee>employee =employeeRepo.findById(id);
        if (employee.isPresent()){
            employeeRepo.deleteById(id);

        }else {throw new IdNotFoundException(id+"-Id is not found");}
    }

    @Override
    public Employee update(Long id, EmployeeDTO dto) {
      Optional<Employee> foundEmployee= employeeRepo.findById(id);
        if(foundEmployee.isPresent()){
            Employee editEmployee=foundEmployee.get();
            editEmployee = Employee.builder()
                    .id(editEmployee.getId())
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .jobTitle(dto.getJobTitle())
                    .phone(dto.getPhone())
                    .employeeCode(editEmployee.getEmployeeCode())
                    .build();
            return editEmployee;
        }
        throw new IdNotFoundException(id+"-Id is not found");
    }




}
