package zoowsome.models.animals;

public class Turtle extends Reptile{
	public Turtle(boolean layEggs,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(layEggs,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Turtle()
	{
		super(true,"Turtle",4,1.6,0.1);
	}
}
