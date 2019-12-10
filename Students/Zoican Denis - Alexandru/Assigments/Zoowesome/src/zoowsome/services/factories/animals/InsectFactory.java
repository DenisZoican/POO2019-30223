package zoowsome.services.factories.animals;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Bee;
import zoowsome.models.animals.Beetle;
import zoowsome.models.animals.Spider;

public class InsectFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type,String name) throws Exception {
		int r1 = (int)(Math.random()*10)%2;
		int r2 = (int)(Math.random()*10)%2;
		
		if (Constants.Animals.Insects.BEE.equals(type)) {
			return new Bee((r1==1),(r2==1),6,name,1.3,0.3); 
		} else if (Constants.Animals.Insects.BEETLE.equals(type)) {
			return new Beetle((r1==1),(r2==1),6,name,4.4,0.9);
		} else if (Constants.Animals.Insects.SPIDER.equals(type)){
			return new Spider((r1==1),(r2==1),8,name,1.2,0.67);
		} else {
			throw new Exception("Invalid type");
		}
	}

}
