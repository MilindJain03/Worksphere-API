package com.example.employee_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_management.model.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository emplRepository;

    public List<Employee> getAllEmployees() {
        return emplRepository.findAll();
    }

    public Employee createEmployee(Employee anEmpl) {
        // Validate phone number if needed
        if (anEmpl.getPhone() == null) {
            anEmpl.setPhone(""); // Set default empty string if phone is null
        }
        return emplRepository.save(anEmpl);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return emplRepository.findById(id)
            .map(employee -> {
                employee.setName(updatedEmployee.getName());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setRole(updatedEmployee.getRole());
                employee.setPhone(updatedEmployee.getPhone() != null ? 
                    updatedEmployee.getPhone() : "");
                return emplRepository.save(employee);
            })
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long id) {
        if (emplRepository.existsById(id)) {
            emplRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found (d)");
        }
    }

    public List<Employee> searchEmployees(String query) {
        return emplRepository.findByNameContainingIgnoreCaseOrRoleContainingIgnoreCase(query, query);
    }
}
