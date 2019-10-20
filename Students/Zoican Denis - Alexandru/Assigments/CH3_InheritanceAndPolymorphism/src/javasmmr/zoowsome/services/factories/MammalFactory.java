package javasmmr.zoowsome.services.factories;
import  javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Bear;
import javasmmr.zoowsome.models.animals.Cow;
import javasmmr.zoowsome.models.animals.Llama;
import javasmmr.zoowsome.services.factories.Constants;

public class MammalFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Mammals.BEAR.equals(type)) {
			return new Bear(); // leave empty constructor, for now!
		} else if (Constants.Animals.Mammals.COW.equals(type)) {
			return new Cow();
		} else if (Constants.Animals.Mammals.LLAMA.equals(type)){
			return new Llama();
		} else {
			throw new Exception("Invalid type");
		}
	}

}

