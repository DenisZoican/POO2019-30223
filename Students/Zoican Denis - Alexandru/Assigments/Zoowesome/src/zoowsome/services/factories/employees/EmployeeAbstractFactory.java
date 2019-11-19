package zoowsome.services.factories.employees;

import java.math.BigDecimal;

import zoowsome.models.employees.Employee;

public abstract class EmployeeAbstractFactory {
	public abstract Employee getEmployee(String type) throws Exception;
}
