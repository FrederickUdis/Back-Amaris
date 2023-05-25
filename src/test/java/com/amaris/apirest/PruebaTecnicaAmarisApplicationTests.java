package com.amaris.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.amaris.apirest.service.EmployeeBusiness;

@SpringBootTest
class PruebaTecnicaAmarisApplicationTests {

	 private EmployeeBusiness employeeBusiness;

	    @BeforeEach
	    public void setUp() {
	        employeeBusiness = new EmployeeBusiness();
	    }

	    @Test
	    public void testCalculateAnnualSalary() {
	    	System.out.println("bandera 1");
	        int monthlySalary = 5000;
	        int expectedAnnualSalary = 60000;

	        int actualAnnualSalary = employeeBusiness.calculateAnnualSalary(monthlySalary);

	        assertEquals(expectedAnnualSalary, actualAnnualSalary);
	    }
}
