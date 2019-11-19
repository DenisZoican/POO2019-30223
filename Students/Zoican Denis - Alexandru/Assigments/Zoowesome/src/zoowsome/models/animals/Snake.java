package zoowsome.models.animals;

public class Snake extends Reptile{
	public Snake(boolean layEggs,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(layEggs,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Snake()
	{
		super(true,"Gabi",0,1.5,0.87);
	}
}
