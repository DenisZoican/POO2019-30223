package zoowsome.services.factories.animals;
import  zoowsome.models.animals.Animal;
import  zoowsome.models.animals.Bear;
import  zoowsome.models.animals.Cow;
import  zoowsome.models.animals.Llama;
import  zoowsome.services.factories.animals.Constants;

public class MammalFactory extends SpeciesFactory {

	private float temp[] = {55,48,50,44};
	private float hair[] = {80,90,87,99};
	
	
	@Override
	public Animal getAnimal(String type,String name) throws Exception {
		int r1 = (int)(Math.random()*10)%4;
		int r2 = (int)(Math.random()*10)%4;
		
		if (Constants.Animals.Mammals.BEAR.equals(type)) {
			return new Bear(temp[r1],temp[r2],name,4,0.3,0.6); 
		} else if (Constants.Animals.Mammals.COW.equals(type)) {
			return new Cow(temp[r1],temp[r2],name,4,2.3,0.98); 
		} else if (Constants.Animals.Mammals.LLAMA.equals(type)){
			return new Llama(temp[r1],temp[r2],name,4,3.3,0.34); 
		} else {
			throw new Exception("Invalid type");
		}
	}

}

