package javasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Catfish;
import javasmmr.zoowsome.models.animals.Clownfish;
import javasmmr.zoowsome.models.animals.Goldfish;

public class AquaticFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Aquatics.GOLDFISH.equals(type)) {
			return new Goldfish(); // leave empty constructor, for now!
		} else if (Constants.Animals.Aquatics.CATFISH.equals(type)) {
			return new Catfish();
		} else if (Constants.Animals.Aquatics.CLOWNFISH.equals(type)){
			return new Clownfish();
		} else {
			throw new Exception("Invalid type");
		}
	}

}