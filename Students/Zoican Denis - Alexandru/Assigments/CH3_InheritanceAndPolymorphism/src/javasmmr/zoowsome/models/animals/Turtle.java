package javasmmr.zoowsome.models.animals;

public class Turtle extends Reptile{
	public Turtle(boolean layEggs,String name,Integer nrOfLegs){
		super(layEggs,name,nrOfLegs);
	}
	
	public Turtle()
	{
		super(true,"Turtle",4);
	}
}
