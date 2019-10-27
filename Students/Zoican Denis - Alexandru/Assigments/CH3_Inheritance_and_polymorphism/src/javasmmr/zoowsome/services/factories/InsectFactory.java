package javasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Bee;
import javasmmr.zoowsome.models.animals.Beetles;
import javasmmr.zoowsome.models.animals.Spider;

public class InsectFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		int r1 = (int)(Math.random()*10)%2;
		int r2 = (int)(Math.random()*10)%2;
		
		if (Constants.Animals.Insects.BEE.equals(type)) {
			return new Bee((r1==1),(r2==1),6,"Bee"); // leave empty constructor, for now!
		} else if (Constants.Animals.Insects.BEETLE.equals(type)) {
			return new Beetles((r1==1),(r2==1),6,"Beetle");
		} else if (Constants.Animals.Insects.SPIDER.equals(type)){
			return new Spider((r1==1),(r2==1),8,"Spider");
		} else {
			throw new Exception("Invalid type");
		}
	}

}
