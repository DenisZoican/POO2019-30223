package javasmmr.zoowsome.services.factories;
import  javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Bear;
import javasmmr.zoowsome.models.animals.Cow;
import javasmmr.zoowsome.models.animals.Llama;
import javasmmr.zoowsome.services.factories.Constants;

public class MammalFactory extends SpeciesFactory {

	private float temp[] = {55,48,50,44};
	private float hair[] = {80,90,87,99};
	
	
	@Override
	public Animal getAnimal(String type) throws Exception {
		int r1 = (int)(Math.random()*10)%4;
		int r2 = (int)(Math.random()*10)%4;
		
		if (Constants.Animals.Mammals.BEAR.equals(type)) {
			return new Bear(temp[r1],temp[r2],"Bear",4); 
		} else if (Constants.Animals.Mammals.COW.equals(type)) {
			return new Cow(temp[r1],temp[r2],"Bear",4); 
		} else if (Constants.Animals.Mammals.LLAMA.equals(type)){
			return new Llama(temp[r1],temp[r2],"Bear",4); 
		} else {
			throw new Exception("Invalid type");
		}
	}

}

