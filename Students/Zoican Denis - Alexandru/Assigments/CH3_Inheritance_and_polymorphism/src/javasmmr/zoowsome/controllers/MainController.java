package javasmmr.zoowsome.controllers;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Aquatic;
import javasmmr.zoowsome.models.animals.Bear;
import javasmmr.zoowsome.services.factories.AnimalFactory;
import javasmmr.zoowsome.services.factories.Constants;
import javasmmr.zoowsome.services.factories.Constants.Animals;
import javasmmr.zoowsome.services.factories.SpeciesFactory;
import javasmmr.zoowsome.models.animals.Bird;
import javasmmr.zoowsome.models.animals.Insect;
import javasmmr.zoowsome.models.animals.Mammal;
import javasmmr.zoowsome.models.animals.Reptile;
import javasmmr.zoowsome.models.animals.Turtle;

public class MainController {

	public static void main(String[] args) throws Exception {
		AnimalFactory abstractFactory = new AnimalFactory();

		int counter = 50;

		Animal an[] = new Animal[50];

		int m = 0;

		for (int i = 0; i < counter; i++) {
			int r1 = (int) (Math.random() * 10) % 5;
			int r2 = (int) (Math.random() * 10) % 3;
			if (r1 == 0) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);

				if (r2 == 0) {
					an[m] = (Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.BEAR);
				} else if (r2 == 1) {
					an[m] = (Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.COW);
				} else if (r2 == 2) {
					an[m] = (Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.LLAMA);
				}
				m++;
			} else if (r1 == 1) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);

				if (r2 == 0) {
					an[m] = (Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.CATFISH);
				} else if (r2 == 1) {
					an[m] = (Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.CLOWNFISH);
				} else if (r2 == 2) {
					an[m] = (Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.GOLDFISH);
				}
				m++;
			} else if (r1 == 2) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Insects);

				if (r2 == 0) {
					an[m] = (Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.BEE);
				} else if (r2 == 1) {
					an[m] = (Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.BEETLE);
				} else if (r2 == 2) {
					an[m] = (Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.SPIDER);
				}
				m++;
			} else if (r1 == 3) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Birds);

				if (r2 == 0) {
					an[m] = (Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.FLAMINGO);
				} else if (r2 == 1) {
					an[m] = (Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.PARROT);
				} else if (r2 == 2) {
					an[m] = (Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.PEACOCK);
				}
				m++;
			} else if (r1 == 4) {
				SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);

				if (r2 == 0) {
					an[m] = (Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.CHAMELEON);
				} else if (r2 == 1) {
					an[m] = (Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.SNAKE);
				} else if (r2 == 2) {
					an[m] = (Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.TURTLE);
				}
				m++;
			}
		}
		
		
		for(int i=0;i<counter;i++)
		{
			if(an[i] instanceof Reptile) {
				String s = new String(""+an[i].getClass());
				System.out.println("Hello! I'm a "+s.substring(39,s.length())+" with  "+an[i].getNrOfLegs()+" legs and I lay eggs "+((Reptile)an[i]).getLayEggs());
			} else if(an[i] instanceof Mammal) {
				String s = new String(""+an[i].getClass());
				System.out.println("Hello! I'm a "+s.substring(39,s.length())+" with  "+an[i].getNrOfLegs()+" legs and my body temperature is "+((Mammal)an[i]).getNormalBodyTemp());
			} else if(an[i] instanceof Aquatic) {
				String s = new String(""+an[i].getClass());
				System.out.println("Hello! I'm a "+s.substring(39,s.length())+" with  "+an[i].getNrOfLegs()+" legs and I swim in "+((Aquatic)an[i]).getTaterType());
			} else if(an[i] instanceof Insect) {
				String s = new String(""+an[i].getClass());
				System.out.println("Hello! I'm a "+s.substring(39,s.length())+" with  "+an[i].getNrOfLegs()+" legs and I can fly "+((Insect)an[i]).getCanFly());
			} else if(an[i] instanceof Bird) {
				String s = new String(""+an[i].getClass());
				System.out.println("Hello! I'm a "+s.substring(39,s.length())+" with  "+an[i].getNrOfLegs()+" legs and I migrate "+((Bird)an[i]).getMigrates());
			}
		}
	}
	
	
}
