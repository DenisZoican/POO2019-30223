package zoowsome.services.factories.animals;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Flamingo;
import zoowsome.models.animals.Parrot;
import zoowsome.models.animals.Peacock;

public class BirdFactory extends SpeciesFactory {

	private Integer alt[] = {55,48,50,44};
	
	@Override
	public Animal getAnimal(String type,String name) throws Exception {
		int r1 = (int)(Math.random()*10)%2;
		int r2 = (int)(Math.random()*10)%4;
		if (Constants.Animals.Birds.FLAMINGO.equals(type)) {
			return new Flamingo((r1==1),alt[r2],name,2,2.3,0.3); 
		} else if (Constants.Animals.Birds.PEACOCK.equals(type)) {
			return new Peacock((r1==1),alt[r2],name,2,1.2,0.6);
		} else if (Constants.Animals.Birds.PARROT.equals(type)){
			return new Parrot((r1==1),alt[r2],name,2,2.2,0.3);
		} else {
			throw new Exception("Invalid type");
		}
	}

}
