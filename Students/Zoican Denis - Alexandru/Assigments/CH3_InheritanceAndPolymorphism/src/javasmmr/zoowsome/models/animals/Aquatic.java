package javasmmr.zoowsome.models.animals;

public abstract class Aquatic extends Animal{
	enum type {
		    saltwater,
		    freshwater
		  }
	Integer avgSwimDepth;
	type waterType;
	
	Aquatic(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs){
		super(nrOfLegs,name);
		this.avgSwimDepth = avgSwimDepth;
		this.waterType = waterType;
	}
	
}
