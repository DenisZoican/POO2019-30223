package javasmmr.zoowsome.services.factories;
import javasmmr.zoowsome.models.animals.Animal;
import javasmmr.zoowsome.models.animals.Chameleon;
import javasmmr.zoowsome.models.animals.Snake;
import javasmmr.zoowsome.models.animals.Turtle;

public class ReptileFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		int r1 = (int)(Math.random()*10)%2;
		if (Constants.Animals.Reptiles.TURTLE.equals(type)) {
			return new Turtle((r1==1),"Turtle",4); // leave empty constructor, for now!
		} else if (Constants.Animals.Reptiles.SNAKE.equals(type)) {
			return new Snake((r1==1),"Snake",4);
		} else if (Constants.Animals.Reptiles.CHAMELEON.equals(type)){
			return new Chameleon((r1==1),"Chameleon",4);
		} else {
			throw new Exception("Invalid type");
		}
	}
}
