package zoowsome.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Aquatic;
import zoowsome.models.animals.Bear;
import zoowsome.models.animals.Bird;
import zoowsome.models.animals.Insect;
import zoowsome.models.animals.Mammal;
import zoowsome.models.animals.Reptile;
import zoowsome.models.animals.Spider;
import zoowsome.models.animals.Turtle;
import zoowsome.models.employees.Caretaker;
import zoowsome.services.factories.animals.AnimalFactory;
import zoowsome.services.factories.animals.Constants;
import zoowsome.services.factories.animals.SpeciesFactory;
import zoowsome.services.factories.employees.CaretakerFactory;
import zoowsome.services.factories.employees.EmployeeAbstractFactory;
import zoowsome.services.factories.employees.EmployeeFactory;
import zoowsome.services.factories.animals.Constants.Animals;

public class MainController {

	public static void main(String[] args) throws Exception {
		AnimalFactory abstractFactory = new AnimalFactory();

		int counter = 50;
		
		ArrayList<Animal> an = new ArrayList<Animal>();
		ArrayList<Caretaker> car = new ArrayList<Caretaker>();

		an.add(new Spider());
		
		for (int i = 0; i < counter; i++) {
			int r1 = (int) (Math.random() * 10) % 5;
			int r2 = (int) (Math.random() * 10) % 3;
			if (r1 == 0) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
				if (r2 == 0) {
					an.add((Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.BEAR));
				} else if (r2 == 1) {
					an.add((Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.COW));
				} else if (r2 == 2) {
					an.add((Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.LLAMA));
				}
			} else if (r1 == 1) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
				if (r2 == 0) {
					an.add((Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.CATFISH));
				} else if (r2 == 1) {
					an.add((Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.CLOWNFISH));
				} else if (r2 == 2) {
					an.add((Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.GOLDFISH));
				}
			} else if (r1 == 2) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Insects);

				if (r2 == 0) {
					an.add((Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.BEE));
				} else if (r2 == 1) {
					an.add((Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.BEETLE));
				} else if (r2 == 2) {
					an.add((Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.SPIDER));
				}
			} else if (r1 == 3) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Birds);

				if (r2 == 0) {
					an.add((Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.FLAMINGO));
				} else if (r2 == 1) {
					an.add((Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.PARROT));
				} else if (r2 == 2) {
					an.add((Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.PEACOCK));
				}
			} else if (r1 == 4) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);

				if (r2 == 0) {
					an.add((Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.CHAMELEON));
				} else if (r2 == 1) {
					an.add((Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.SNAKE));
				} else if (r2 == 2) {
					an.add((Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.TURTLE));
				}
			}
		}

		for (Animal a:an) {
			if (a instanceof Reptile) {
				String s = new String("" + a.getClass());
				System.out.println("Hello! I'm a " + s.substring(30, s.length()) + " with  " + a.getNrOfLegs()
						+ " legs and I lay eggs " + ((Reptile) a).getLayEggs());
			} else if (a instanceof Mammal) {
				String s = new String("" + a.getClass());
				System.out.println("Hello! I'm a " + s.substring(30, s.length()) + " with  " + a.getNrOfLegs()
						+ " legs ad my body temperature is " + ((Mammal) a).getNormalBodyTemp());
			} else if (a instanceof Aquatic) {
				String s = new String("" + a.getClass());
				System.out.println("Hello! I'm a " + s.substring(30, s.length()) + " with  " + a.getNrOfLegs()
						+ " legs ad I swim in " + ((Aquatic) a).getTaterType());
			} else if (a instanceof Insect) {
				String s = new String("" + a.getClass());
				System.out.println("Hello! I'm a " + s.substring(30, s.length()) + " with  " + a.getNrOfLegs()
						+ " legs ad I ca fly " + ((Insect) a).getCanFly());
			} else if (a instanceof Bird) {
				String s = new String("" + a.getClass());
				System.out.println("Hello! I'm a " + s.substring(30, s.length()) + " with  " + a.getNrOfLegs()
						+ " legs ad I migrate " + ((Bird) a).getMigrates());
			}
		}

		EmployeeFactory employeeFactory = new EmployeeFactory();
		EmployeeAbstractFactory caretakerFactory = employeeFactory.getEmployeeFactory(Constants.Employees.Caretaker);

		for (int i = 0; i < 5; i++)
			car.add((Caretaker) caretakerFactory.getEmployee("Caretaker"));

		int i = 0;
		for (Caretaker c : car) {
			{
				for (Animal a : an) {
					{
						if (c.getIsDead() == false && a.isTakenCareOf() == false) {
							String result = c.takeCareOf(a);
							DecimalFormat numberFormat = new DecimalFormat("#.00");
							if (result.equals(Constants.Employees.CaretakerStatus.TCO_KILLED) == true) {
								System.out.println("The caretaker with the id:" + i + " is dead!The killer: "+a.getName());
							} else if (result.equals(Constants.Employees.CaretakerStatus.TCO_SUCCES) == true) {
								System.out.println("The caretaker with the id:" + i + " took care of a "+a.getName());
							} else if (result.equals(Constants.Employees.CaretakerStatus.TCO_NO_TIME) == true) {
								System.out.println("The caretaker with the id:" + i + " didn't have enough time for "+a.getName()+" Maintenance cost was "+a.getMaintenanceCost()+" and the caretaker had just "+numberFormat.format(c.getWorkingHours()));
							} 
						}
					}
				}
				i++;
			}
		}
		int j = 1;
		for(Animal a:an) {
			System.out.println(a.getName()+" "+j+" is taken care of:"+a.isTakenCareOf());
			j++;
		}

		/*
		for(Animal a:an) {
			System.out.println("Animal "+a.getName());
			//an.remove(a);
		}*/
		
		Iterator<Animal> it = an.iterator();
		
		while(it.hasNext()) {
			System.out.println("Animal "+it.next().getName());
			it.remove();
		}
				
		//Nu este posibil acest lucru pentru ca nu este permis sa stergem si sa parcurgem in acelasi timp elementele dintr-un ArrrayList.
		//Eroarea pe care o intalnim este ConcurrentModificationException.
	}
}
