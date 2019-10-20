package javasmmr.zoowsome.services.factories;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Chameleon;
import javasmmr.zoowsome.models.animals.Snake;
import javasmmr.zoowsome.models.animals.Turtle;

public class ReptileFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		if (Constants.Animals.Reptiles.TURTLE.equals(type)) {
			return new Turtle(); // leave empty constructor, for now!
		} else if (Constants.Animals.Reptiles.SNAKE.equals(type)) {
			return new Snake();
		} else if (Constants.Animals.Reptiles.CHAMELEON.equals(type)){
			return new Chameleon();
		} else {
			throw new Exception("Invalid type");
		}
	}
}
