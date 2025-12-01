package org.n.r.s.em_system.employee_mst.Service;

import java.util.List;

import org.n.r.s.em_system.employee_mst.Modal.EmployeeRequest;
import org.n.r.s.em_system.employee_mst.Modal.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    EmployeeResponse getEmployeeById(Long id);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse updateEmployee(Long id, EmployeeRequest request);
    void deleteEmployee(Long id);
}
