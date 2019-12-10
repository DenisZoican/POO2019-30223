package zoowsome.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class MainMenuFrame extends ZooFrame {

	private JButton btnAdd;
	private JButton btnList;
	private JButton btnAddEmp;
	private JButton btnListEmp;
	private JButton btnSaveAndExit;
	private JComboBox inpAnimal;
	private JTextField inpNameAnimal;
	private JLabel inpNameLabel;

	public MainMenuFrame(String title) {
		super(title);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel = new JPanel(); // adding empty panel to fill grid layout contentPanel.add(panel);

		JPanel pan = new JPanel();
		contentPanel.add(pan);
		SpringLayout slPanel = new SpringLayout();
		pan.setLayout(slPanel);

		String[] animals = {"Bear","Bee","Beetle","Catfish","Chameleon","Clownfish","Cow","Flamingo","Goldfish","Llama","Parrot","Peacock","Snake","Spider","Turtle"};
		
		setInpAnimal(new JComboBox(animals));
		setInpNameAnimal(new JTextField(20));
		setInpNameLabel(new JLabel("Insert the animal's name:"));

		slPanel.putConstraint(SpringLayout.NORTH, inpAnimal, 25, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, inpAnimal, 25, SpringLayout.WEST, pan);
		slPanel.putConstraint(SpringLayout.NORTH, inpNameLabel, 55, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, inpNameLabel, 25, SpringLayout.WEST, pan);
		slPanel.putConstraint(SpringLayout.NORTH, inpNameAnimal, 75, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, inpNameAnimal, 25, SpringLayout.WEST, pan);

		pan.add(inpAnimal);
		pan.add(inpNameLabel);
		pan.add(inpNameAnimal);

		btnAdd = new JButton("Add Animal");
		slPanel.putConstraint(SpringLayout.NORTH, btnAdd, 105, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnAdd, 23, SpringLayout.WEST, pan);
		pan.add(btnAdd);

		btnList = new JButton("List all animals");
		slPanel.putConstraint(SpringLayout.NORTH, btnList, 150, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnList, 23, SpringLayout.WEST, pan);
		pan.add(btnList);
		
		btnAddEmp = new JButton("Add random employee");
		slPanel.putConstraint(SpringLayout.NORTH, btnAddEmp, 220, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnAddEmp, 23, SpringLayout.WEST, pan);
		pan.add(btnAddEmp);
		
		btnListEmp = new JButton("List all employees");
		slPanel.putConstraint(SpringLayout.NORTH, btnListEmp, 250, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnListEmp, 23, SpringLayout.WEST, pan);
		pan.add(btnListEmp);

		btnSaveAndExit = new JButton("Save and Exit");
		slPanel.putConstraint(SpringLayout.NORTH, btnSaveAndExit, 300, SpringLayout.NORTH, pan);
		slPanel.putConstraint(SpringLayout.WEST, btnSaveAndExit, 23, SpringLayout.WEST, pan);
		pan.add(btnSaveAndExit);

		JPanel panel_2 = new JPanel();
		contentPanel.add(panel_2);
		setVisible(true);
	}

	public void setAddButtonActionListener(ActionListener a) {
		btnAdd.addActionListener(a);
	}
	
	public void setSaveButtonActionListener(ActionListener a) {
		btnSaveAndExit.addActionListener(a);
	}

	public void setAddEmpButtonActionListener(ActionListener a) {
		btnAddEmp.addActionListener(a);
	}
	
	public void setListButtonActionListener(ActionListener a) {
		btnList.addActionListener(a);
	}
	
	public void setListEmpButtonActionListener(ActionListener a) {
		btnListEmp.addActionListener(a);
	}

	public void setSaveAndExitButtonActionListener(ActionListener a) {
		btnSaveAndExit.addActionListener(a);
	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub

	}

	public JComboBox getInpAnimal() {
		return inpAnimal;
	}

	public void setInpAnimal(JComboBox inpAnimal) {
		this.inpAnimal = inpAnimal;
	}

	public JTextField getInpNameAnimal() {
		return inpNameAnimal;
	}

	public void setInpNameAnimal(JTextField inpNameAnimal) {
		this.inpNameAnimal = inpNameAnimal;
	}

	public JLabel getInpNameLabel() {
		return inpNameLabel;
	}

	public void setInpNameLabel(JLabel inpNameLabel) {
		this.inpNameLabel = inpNameLabel;
	}

	public JButton getBtnAddEmp() {
		return btnAddEmp;
	}

	public void setBtnAddEmp(JButton btnAddEmp) {
		this.btnAddEmp = btnAddEmp;
	}

}