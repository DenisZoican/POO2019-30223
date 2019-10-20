package javasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Bee;
import javasmmr.zoowsome.models.animals.Beetles;
import javasmmr.zoowsome.models.animals.Spider;

public class InsectFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Insects.BEE.equals(type)) {
			return new Bee(); // leave empty constructor, for now!
		} else if (Constants.Animals.Insects.BEETLE.equals(type)) {
			return new Beetles();
		} else if (Constants.Animals.Insects.SPIDER.equals(type)){
			return new Spider();
		} else {
			throw new Exception("Invalid type");
		}
	}

}
