package javasmmr.zoowsome.models.animals;

public abstract class Reptile extends Animal{
	public boolean layEggs;
	
	Reptile(boolean layEggs,String name,Integer nrOfLegs){
		super(nrOfLegs,name);
		this.layEggs = layEggs;
	}
}
