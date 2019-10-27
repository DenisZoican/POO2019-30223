package javasmmr.zoowsome.models.animals;

public class Chameleon extends Reptile{
	public Chameleon(boolean layEggs,String name,Integer nrOfLegs){
		super(layEggs,name,nrOfLegs);
	}
	
	public Chameleon()
	{
		super(true,"Chameleon",4);
	}
}
