package zoowsome.services.factories.animals;
import  zoowsome.models.animals.Animal;

public abstract class SpeciesFactory {
	public abstract Animal getAnimal(String type,String name) throws Exception;
}

