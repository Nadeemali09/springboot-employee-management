package org.n.r.s.em_system.employee_mst.Modal;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class EmployeeRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    private String department;
    private Double salary;
}
