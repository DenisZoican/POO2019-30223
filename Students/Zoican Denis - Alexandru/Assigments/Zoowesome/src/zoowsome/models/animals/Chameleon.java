package zoowsome.models.animals;

public class Chameleon extends Reptile{
	public Chameleon(boolean layEggs,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(layEggs,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Chameleon()
	{
		super(true,"Chameleon",4,3.4,0.6);
	}
}
