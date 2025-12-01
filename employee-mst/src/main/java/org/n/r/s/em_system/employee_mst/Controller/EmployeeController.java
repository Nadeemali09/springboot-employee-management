package org.n.r.s.em_system.employee_mst.Controller;

import java.util.List;

import org.n.r.s.em_system.employee_mst.Modal.EmployeeRequest;
import org.n.r.s.em_system.employee_mst.Modal.EmployeeResponse;
import org.n.r.s.em_system.employee_mst.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    

    @PostMapping
    public ResponseEntity<EmployeeResponse> create(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(service.createEmployee(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(
            @PathVariable Long id,
            @RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(service.updateEmployee(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
