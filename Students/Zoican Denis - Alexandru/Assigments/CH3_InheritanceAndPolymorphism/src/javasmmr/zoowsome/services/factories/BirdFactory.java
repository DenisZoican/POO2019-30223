package javasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Flamingo;
import javasmmr.zoowsome.models.animals.Parrot;
import javasmmr.zoowsome.models.animals.Peacock;

public class BirdFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Birds.FLAMINGO.equals(type)) {
			return new Flamingo(); // leave empty constructor, for now!
		} else if (Constants.Animals.Birds.PEACOCK.equals(type)) {
			return new Peacock();
		} else if (Constants.Animals.Birds.PARROT.equals(type)){
			return new Parrot();
		} else {
			throw new Exception("Invalid type");
		}
	}

}
