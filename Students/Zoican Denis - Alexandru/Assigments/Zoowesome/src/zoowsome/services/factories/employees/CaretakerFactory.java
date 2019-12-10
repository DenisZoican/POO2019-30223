package zoowsome.services.factories.employees;

import java.math.BigDecimal;

import zoowsome.models.employees.Caretaker;
import zoowsome.models.employees.Employee;

public class CaretakerFactory extends EmployeeAbstractFactory{
	
	private static long id;
	@Override
	public Employee getEmployee(String type) throws Exception {
		id++;
		return new Caretaker("Caretaker",(long)id,new BigDecimal(id*100),10.2);
	}
}
