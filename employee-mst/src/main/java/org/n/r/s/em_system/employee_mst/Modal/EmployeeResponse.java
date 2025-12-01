package org.n.r.s.em_system.employee_mst.Modal;

import ch.qos.logback.core.status.Status;
import lombok.Data;

@Data
public class EmployeeResponse {
    private Long id;
    private String name;
    private String email;
    private String department;
    private Double salary;
    private Status status;
}
