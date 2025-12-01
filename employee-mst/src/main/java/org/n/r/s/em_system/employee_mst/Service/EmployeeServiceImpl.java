package org.n.r.s.em_system.employee_mst.Service;

import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

import org.n.r.s.em_system.employee_mst.Entity.Employee;
import org.n.r.s.em_system.employee_mst.Modal.EmployeeRequest;
import org.n.r.s.em_system.employee_mst.Modal.EmployeeResponse;
import org.n.r.s.em_system.employee_mst.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

   
    private final EmployeeRepository employeeRepo;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request, employee);
        employee.setJoiningDate(LocalDate.now());
        Employee saved = employeeRepo.save(employee);
        return convert(saved);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee Not Found"));
        return convert(employee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepo.findAll()
            .stream()
            .map(this::convert)
            .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest request) {
        Employee employee = employeeRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        BeanUtils.copyProperties(request, employee);
        Employee updated = employeeRepo.save(employee);
        return convert(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee Not Found"));

        employeeRepo.delete(employee);
    }

    private EmployeeResponse convert(Employee employee) {
        EmployeeResponse response = new EmployeeResponse();
        BeanUtils.copyProperties(employee, response);
        return response;
    }
}

