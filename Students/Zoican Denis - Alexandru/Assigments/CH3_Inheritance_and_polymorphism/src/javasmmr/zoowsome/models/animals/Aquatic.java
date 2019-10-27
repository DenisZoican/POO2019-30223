package javasmmr.zoowsome.models.animals;

public abstract class Aquatic extends Animal{
	public enum type {
		    saltwater,
		    freshwater
		  }
	public Integer avgSwimDepth;
	public type waterType;
	
	Aquatic(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs){
		super(nrOfLegs,name);
		this.avgSwimDepth = avgSwimDepth;
		this.waterType = waterType;
	}
	
}
