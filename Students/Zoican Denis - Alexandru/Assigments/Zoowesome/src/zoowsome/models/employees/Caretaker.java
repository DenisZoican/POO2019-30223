package zoowsome.models.employees;

import java.math.BigDecimal;

import zoowsome.models.animals.Animal;
import zoowsome.services.factories.animals.Constants;

public class Caretaker extends Employee implements Caretaker_1{

	private Double workingHours;
	public Caretaker(String name, Long id, BigDecimal salary,Double workingHours) {
		super(name, id, salary);
		this.workingHours = workingHours;
		
	}
	public Double getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(Double workingHours) {
		this.workingHours = workingHours;
	}
	@Override
	public String takeCareOf(Animal a) {
		if(a.kill())
		{
			this.setIsDead(true);
			return Constants.Employees.CaretakerStatus.TCO_KILLED;
		}
		else if(this.workingHours<a.getMaintenanceCost()) {
			return Constants.Employees.CaretakerStatus.TCO_NO_TIME;
		}
		
		a.setTakenCareOf(true);
		this.workingHours-=a.getMaintenanceCost();
		
		return Constants.Employees.CaretakerStatus.TCO_SUCCES;
	}
}
