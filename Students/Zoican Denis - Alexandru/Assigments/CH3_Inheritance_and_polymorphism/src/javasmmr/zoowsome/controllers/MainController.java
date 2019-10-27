package javasmmr.zoowsome.controllers;


import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Aquatic;
import javasmmr.zoowsome.models.animals.Bear;
import javasmmr.zoowsome.services.factories.AnimalFactory;
import javasmmr.zoowsome.services.factories.Constants;
import javasmmr.zoowsome.services.factories.SpeciesFactory;
import javasmmr.zoowsome.models.animals.Bird;
import javasmmr.zoowsome.models.animals.Insect;
import javasmmr.zoowsome.models.animals.Mammal;
import javasmmr.zoowsome.models.animals.Reptile;

public class MainController {
	
	public static void main(String[] args) throws Exception {
		AnimalFactory abstractFactory = new AnimalFactory();

		int counter = 50;
		
		Bird birds[] = new Bird[50];
		Mammal mammals[] = new Mammal[50];
		Reptile reptiles[] = new Reptile[50];
		Insect insects[] = new Insect[50];
		Aquatic aquatics[] = new Aquatic[50];
		
		int b = 0;
		int m = 0;
		int r = 0;
		int in = 0;
		int a = 0;
		
		for(int i=0;i<counter;i++)
		{
		int r1 = (int)(Math.random()*10)%5;
		int r2 =(int)(Math.random()*10)%3;
		if(r1==0)
		{
			SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Mammals);
			
			if(r2==0)
			{
				mammals[m] = (Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.BEAR);
			}else if(r2==1)
			{
				mammals[m] = (Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.COW);
			}else if(r2==2)
			{
				mammals[m] = (Mammal) speciesFactory1.getAnimal(Constants.Animals.Mammals.LLAMA);
			}
			m++;
		}else if(r1==1)
		{
			SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Aquatics);
			
			if(r2==0)
			{
				aquatics[a] = (Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.CATFISH);
			}else if(r2==1)
			{
				aquatics[a] = (Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.CLOWNFISH);
			}else if(r2==2)
			{
				aquatics[a] = (Aquatic) speciesFactory1.getAnimal(Constants.Animals.Aquatics.GOLDFISH);
			}
			a++;
		}else if(r1==2)
		{
			SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Insects);
			
			if(r2==0)
			{
				insects[in] = (Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.BEE);
			}else if(r2==1)
			{
				insects[in] = (Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.BEETLE);
			}else if(r2==2)
			{
				insects[in] = (Insect) speciesFactory1.getAnimal(Constants.Animals.Insects.SPIDER);
			}
			in++;
		}else if(r1==3)
		{
			SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Birds);
			
			if(r2==0)
			{
				birds[b] = (Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.FLAMINGO);
			}else if(r2==1)
			{
				birds[b] = (Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.PARROT);
			}else if(r2==2)
			{
				birds[b] = (Bird) speciesFactory1.getAnimal(Constants.Animals.Birds.PEACOCK);
			}
			b++;
		}else if(r1==4)
		{
			SpeciesFactory speciesFactory1 = abstractFactory.getSpeciesFactory(Constants.Species.Reptiles);
			
			if(r2==0)
			{
				reptiles[r] = (Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.CHAMELEON);
			}else if(r2==1)
			{
				reptiles[r] = (Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.SNAKE);
			}else if(r2==2)
			{
				reptiles[r] = (Reptile) speciesFactory1.getAnimal(Constants.Animals.Reptiles.TURTLE);
			}
			r++;
		}	
		}
		
		for(int j=0;j<r;j++)
		{
			System.out.println("Hello!I am a "+reptiles[j].getName()+" and I lay eggs. "+reptiles[j].layEggs);
		}
	}

}
