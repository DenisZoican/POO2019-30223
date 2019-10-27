package javasmmr.zoowsome.services.factories;

import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Catfish;
import javasmmr.zoowsome.models.animals.Clownfish;
import javasmmr.zoowsome.models.animals.Goldfish;
import javasmmr.zoowsome.models.animals.Aquatic;

public class AquaticFactory extends SpeciesFactory {

	private Integer depth[] = {12,14,15};
	private Aquatic.type water[] = {Aquatic.type.freshwater,Aquatic.type.saltwater};
	
	@Override
	public Animal getAnimal(String type) throws Exception {
		
		int r1 = (int)(Math.random()*10)%3;
		int r2 = (int)(Math.random()*10)%2;
		
		
		if (Constants.Animals.Aquatics.GOLDFISH.equals(type)) {
			return new Goldfish(depth[r1],water[r2],"Goldfish",0); 
		} else if (Constants.Animals.Aquatics.CATFISH.equals(type)) {
			return new Catfish(depth[r1],water[r2],"Catfish",0); 
		} else if (Constants.Animals.Aquatics.CLOWNFISH.equals(type)){
			return new Clownfish(depth[r1],water[r2],"Clownfish",0); 
		} else {
			throw new Exception("Invalid type");
		}
	}

}