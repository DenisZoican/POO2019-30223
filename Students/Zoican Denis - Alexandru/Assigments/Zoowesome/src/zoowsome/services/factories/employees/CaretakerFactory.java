package zoowsome.services.factories.employees;

import java.math.BigDecimal;

import zoowsome.models.employees.Caretaker;
import zoowsome.models.employees.Employee;

public class CaretakerFactory extends EmployeeAbstractFactory{
	
	@Override
	public Employee getEmployee(String type) throws Exception {
		return new Caretaker("Caretaker",(long)23,new BigDecimal(23),10.2);
	}
}
