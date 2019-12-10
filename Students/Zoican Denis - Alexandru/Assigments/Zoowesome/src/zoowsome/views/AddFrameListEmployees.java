package zoowsome.views;

import java.util.ArrayList;

import zoowsome.models.animals.Animal;
import zoowsome.models.employees.Caretaker;
import zoowsome.models.employees.Employee;

public class AddFrameListEmployees extends ZooFrame {

	public AddFrameListEmployees(String title,ArrayList<Employee> em_gui) {
		super(title);
		for(Employee c:em_gui) {
		contentPanel.add(new EmployeePanel(c.getName(),c.getIsDead(),c.getClass().getName().substring(26),c.getSalary(),((Caretaker)c).getWorkingHours()));
		}
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub
		
	}



}