package org.n.r.s.em_system.employee_mst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeMstApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMstApplication.class, args);
	}

}
