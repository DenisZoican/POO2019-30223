package zoowsome.services.factories.animals;
import  zoowsome.models.animals.Animal;
import  zoowsome.models.animals.Chameleon;
import  zoowsome.models.animals.Snake;
import  zoowsome.models.animals.Turtle;

public class ReptileFactory extends SpeciesFactory {

	@Override
	public Animal getAnimal(String type) throws Exception {
		int r1 = (int)(Math.random()*10)%2;
		if (Constants.Animals.Reptiles.TURTLE.equals(type)) {
			return new Turtle((r1==1),"Turtle",4,2.3,0.5);
		} else if (Constants.Animals.Reptiles.SNAKE.equals(type)) {
			return new Snake((r1==1),"Snake",4,1.2,0.56);
		} else if (Constants.Animals.Reptiles.CHAMELEON.equals(type)){
			return new Chameleon((r1==1),"Chameleon",4,5.5,0.3);
		} else {
			throw new Exception("Invalid type");
		}
	}
}
