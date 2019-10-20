package javasmmr.zoowsome.models.animals;

public class Snake extends Reptile{
	public Snake(boolean layEggs,String name,Integer nrOfLegs){
		super(layEggs,name,nrOfLegs);
	}
	
	public Snake()
	{
		super(true,"Gabi",0);
	}
}
