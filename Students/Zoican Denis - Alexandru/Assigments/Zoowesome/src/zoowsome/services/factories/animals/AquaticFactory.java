package zoowsome.services.factories.animals;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Catfish;
import zoowsome.models.animals.Clownfish;
import zoowsome.models.animals.Goldfish;
import zoowsome.models.animals.Aquatic;

public class AquaticFactory extends SpeciesFactory {

	private Integer depth[] = {12,14,15};
	private Aquatic.type water[] = {Aquatic.type.freshwater,Aquatic.type.saltwater};
	
	@Override
	public Animal getAnimal(String type,String name) throws Exception {
		
		int r1 = (int)(Math.random()*10)%3;
		int r2 = (int)(Math.random()*10)%2;
		
		if (Constants.Animals.Aquatics.GOLDFISH.equals(type)) {
			return new Goldfish(depth[r1],water[r2],name,0,1.2,0.007); 
		} else if (Constants.Animals.Aquatics.CATFISH.equals(type)) {
			return new Catfish(depth[r1],water[r2],name,0,3.2,0.003); 
		} else if (Constants.Animals.Aquatics.CLOWNFISH.equals(type)){
			return new Clownfish(depth[r1],water[r2],name,0,2.2,0.02); 
		} else {
			throw new Exception("Invalid type");
		}
	}

}