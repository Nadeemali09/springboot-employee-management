package org.n.r.s.em_system.employee_mst.Repository;


import org.n.r.s.em_system.employee_mst.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    
    
}
