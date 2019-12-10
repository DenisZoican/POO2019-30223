package zoowsome.views;

import java.awt.GridLayout;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class EmployeePanel extends JPanel{
	
	public EmployeePanel(String name,boolean isTakenCareOf,String type,BigDecimal salary,Double working) {
		JLabel name_label = new JLabel("Name: "+name,SwingConstants.CENTER);
		JLabel alive_label= new JLabel("Is dead: "+isTakenCareOf);
		JLabel type_label= new JLabel(type,SwingConstants.CENTER);
		JLabel salary_label= new JLabel("Salary: "+salary,SwingConstants.CENTER);
		JLabel working_label = new JLabel("Working hours: "+working,SwingConstants.CENTER);
		this.setLayout(new GridLayout(2,2));
		this.add(name_label);
		this.add(type_label);
		this.add(alive_label);
		this.add(salary_label);
		this.add(working_label);
	}
}
