package javasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Flamingo;
import javasmmr.zoowsome.models.animals.Parrot;
import javasmmr.zoowsome.models.animals.Peacock;

public class BirdFactory extends SpeciesFactory {

	private Integer alt[] = {55,48,50,44};
	
	@Override
	public Animal getAnimal(String type) throws Exception {
		int r1 = (int)(Math.random()*10)%2;
		int r2 = (int)(Math.random()*10)%4;
		if (Constants.Animals.Birds.FLAMINGO.equals(type)) {
			return new Flamingo((r1==1),alt[r2],"Flamingo",2); // leave empty constructor, for now!
		} else if (Constants.Animals.Birds.PEACOCK.equals(type)) {
			return new Peacock((r1==1),alt[r2],"Peacock",2);
		} else if (Constants.Animals.Birds.PARROT.equals(type)){
			return new Parrot((r1==1),alt[r2],"Parrot",2);
		} else {
			throw new Exception("Invalid type");
		}
	}

}
