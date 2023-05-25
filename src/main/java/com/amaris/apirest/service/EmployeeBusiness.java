package com.amaris.apirest.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeBusiness {
	 private static final int MONTHS_IN_YEAR = 12;

	    public int calculateAnnualSalary(int monthlySalary) {
	        return monthlySalary * MONTHS_IN_YEAR;
	    }
}
