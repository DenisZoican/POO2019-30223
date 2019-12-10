package zoowsome.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.xml.stream.XMLStreamException;

import zoowsome.models.animals.Animal;
import zoowsome.models.employees.Employee;
import zoowsome.repositories.AnimalRepository;
import zoowsome.repositories.EmployeesRepository;
import zoowsome.services.factories.animals.AnimalFactory;
import zoowsome.services.factories.animals.Constants;
import zoowsome.services.factories.employees.EmployeeFactory;
import zoowsome.views.AddControllerListAnimals;
import zoowsome.views.AddControllerListEmployees;
import zoowsome.views.AddFrameListAnimals;
import zoowsome.views.AddFrameListEmployees;
import zoowsome.views.MainMenuFrame;

public class MainMenuController extends AbstractController {

	private ArrayList<Animal> an_gui;
	private ArrayList<Employee> em_gui;
	private AnimalFactory animal_factory;
	private EmployeeFactory employee_factory;
	
	public MainMenuController(MainMenuFrame frame, boolean hasBackButton) {
		super(frame, hasBackButton);
		animal_factory = new AnimalFactory();
		employee_factory = new EmployeeFactory();
		an_gui = new ArrayList<Animal>();
		em_gui = new ArrayList<Employee>();
		frame.setAddButtonActionListener(new AddButtonActionListener());
		frame.setAddEmpButtonActionListener(new AddEmpButtonActionListener());
		frame.setListButtonActionListener(new ListButtonActionListener());
		frame.setListEmpButtonActionListener(new ListEmpButtonActionListener());
		frame.setSaveButtonActionListener(new SaveButtonActionListener());
	}

	private class SaveButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			AnimalRepository animalRepository = new AnimalRepository();
			try {
				animalRepository.save(an_gui);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (XMLStreamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			EmployeesRepository employeesRepository = new EmployeesRepository();
			try {
				employeesRepository.save(em_gui);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (XMLStreamException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}
	
	private class ListButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddControllerListAnimals(new AddFrameListAnimals("ListAnimals", an_gui), true);
		}
	}
	
	private class ListEmpButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new AddControllerListEmployees(new AddFrameListEmployees("ListEmployees", em_gui), true);
		}
	}
	
	private class AddEmpButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				em_gui.add(employee_factory.getEmployeeFactory("Caretaker").getEmployee("Caretaker"));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private class AddButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Animal an = null;
			String name = ((MainMenuFrame) frame).getInpNameAnimal().getText();
			if(name.length()==0) {
				JOptionPane.showMessageDialog(frame, "You must enter a name.");
				return;
			}
			switch (((MainMenuFrame) frame).getInpAnimal().getSelectedItem().toString().toLowerCase()) {
			case ("bee"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Insects)
							.getAnimal(Constants.Animals.Insects.BEE, name);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				break;
			case ("beetle"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Insects)
							.getAnimal(Constants.Animals.Insects.BEETLE, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("spider"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Insects)
							.getAnimal(Constants.Animals.Insects.SPIDER, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("catfish"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Aquatics)
							.getAnimal(Constants.Animals.Aquatics.CATFISH, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("clownfish"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Aquatics)
							.getAnimal(Constants.Animals.Aquatics.CLOWNFISH, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("goldfish"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Aquatics)
							.getAnimal(Constants.Animals.Aquatics.GOLDFISH, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("flamingo"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Birds)
							.getAnimal(Constants.Animals.Birds.FLAMINGO, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("parrot"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Birds)
							.getAnimal(Constants.Animals.Birds.PARROT, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("peacock"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Birds)
							.getAnimal(Constants.Animals.Birds.PEACOCK, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("bear"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Mammals)
							.getAnimal(Constants.Animals.Mammals.BEAR, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("cow"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Mammals)
							.getAnimal(Constants.Animals.Mammals.COW, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("llama"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Mammals)
							.getAnimal(Constants.Animals.Mammals.LLAMA, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("chameleon"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Reptiles)
							.getAnimal(Constants.Animals.Reptiles.CHAMELEON, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("snake"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Reptiles)
							.getAnimal(Constants.Animals.Reptiles.SNAKE, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			case ("turtle"):
				try {
					an = animal_factory.getSpeciesFactory(Constants.Species.Reptiles)
							.getAnimal(Constants.Animals.Reptiles.TURTLE, name);
				} catch (Exception e1) {

					e1.printStackTrace();
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "This type of animal does not exists for this zoo");
				break;
			}
			if (an != null)
				an_gui.add(an);
			((MainMenuFrame) frame).getInpNameAnimal().setText("");
		}

	}

}