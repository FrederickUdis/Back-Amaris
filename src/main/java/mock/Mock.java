package mock;

import java.util.ArrayList;
import java.util.List;
import com.amaris.apirest.model.Employee;

public class Mock {
	public List<Employee> createMockEmployees() {
		List<Employee> mock = new ArrayList<>();
		String[] employeeNames = { "Tiger Nixon", "Garrett Winters", "Ashton Cox", "Cedric Kelly", "Airi Satou",
				"Brielle Williamson", "Herrod Chandler", "Rhona Davidson", "Colleen Hurst", "Sonya Frost",
				"Jena Gaines", "Quinn Flynn", "Charde Marshall", "Haley Kennedy", "Tatyana Fitzpatrick",
				"Michael Silva", "Paul Byrd", "Gloria Little", "Bradley Greer", "Dai Rios", "Jenette Caldwell",
				"Yuri Berry", "Caesar Vance", "Doris Wilder" };
		int[] employeeSalaries = { 320800, 170750, 86000, 433060, 162700, 372000, 137500, 327900, 205500, 103600, 90560,
				342000, 470600, 313500, 385750, 198500, 725000, 237500, 132000, 217500, 345000, 675000, 106450, 85600 };
		int[] employeeAges = { 61, 63, 66, 22, 33, 61, 59, 55, 39, 23, 30, 22, 36, 43, 19, 66, 64, 59, 41, 35, 30, 40,
				21, 23 };
		for (int i = 0; i < employeeNames.length; i++) {
			Employee employee = new Employee();
			employee.setId(i + 1);
			employee.setEmployee_name(employeeNames[i]);
			employee.setEmployee_salary(employeeSalaries[i]);
			employee.setEmployee_age(employeeAges[i]);
			employee.setProfile_image("");
			mock.add(employee);
		}

		return mock;
	}

}
