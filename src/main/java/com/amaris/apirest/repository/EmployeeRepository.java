package com.amaris.apirest.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.amaris.apirest.model.Employee;
import com.amaris.apirest.model.EmployeeIdResponse;
import com.amaris.apirest.model.EmployeesResponse;

import mock.Mock;

@Repository
public class EmployeeRepository {
	private static final String EMPLOYEES_URL = "https://dummy.restapiexample.com/api/v1/employees";
	private static final String EMPLOYEE_URL = "https://dummy.restapiexample.com/api/v1/employee/{id}";
	private final Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
	private final WebClient webClient;

	public EmployeeRepository(WebClient webClient) {
		this.webClient = webClient;
	}

	public List<Employee> getAllEmployees() {
		try {
			return webClient.get().uri(EMPLOYEES_URL).retrieve().bodyToMono(EmployeesResponse.class).block().getData();
		} catch (WebClientResponseException ex) {
			handleErrorResponse(ex);
			Mock allUsers = new Mock();
			return allUsers.createMockEmployees();
		}
	}

	public Employee getEmployeeById(String id) {
		try {
			return webClient.get().uri(EMPLOYEE_URL, id).retrieve().bodyToMono(EmployeeIdResponse.class).block()
					.getData();
		} catch (WebClientResponseException ex) {
			handleErrorResponse(ex);
			Mock allUsers = new Mock();
			return allUsers.createMockEmployees().get(Integer.parseInt(id) - 1);

		}
	}

	private void handleErrorResponse(WebClientResponseException ex) {
		if (ex.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
			logger.error("Error: Recuerso no responde por multiples peticiones+. {}", ex.getMessage());
		} else {
			logger.error("Error: {}. {}", ex.getStatusCode(), ex.getResponseBodyAsString());
		}
	}
}