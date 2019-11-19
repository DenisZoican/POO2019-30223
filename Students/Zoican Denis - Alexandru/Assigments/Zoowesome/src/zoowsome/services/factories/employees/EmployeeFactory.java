package zoowsome.services.factories.employees;

import zoowsome.services.factories.animals.AquaticFactory;
import zoowsome.services.factories.animals.BirdFactory;
import zoowsome.services.factories.animals.Constants;
import zoowsome.services.factories.animals.InsectFactory;
import zoowsome.services.factories.animals.MammalFactory;
import zoowsome.services.factories.animals.ReptileFactory;
import zoowsome.services.factories.animals.SpeciesFactory;
import zoowsome.services.factories.animals.Constants.Employees;

public class EmployeeFactory {
	public EmployeeAbstractFactory getEmployeeFactory(String type) throws Exception {
		if (Constants.Employees.Caretaker.equals(type)) {
			return new CaretakerFactory();
		} else {
			throw new Exception("False");
		}
	}
}
