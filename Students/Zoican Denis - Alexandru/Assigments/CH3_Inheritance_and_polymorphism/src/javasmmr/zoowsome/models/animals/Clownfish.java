package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.models.animals.Aquatic.type;

public class Clownfish extends Aquatic {
	
	public Clownfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs){
		super(avgSwimDepth,waterType,name,nrOfLegs);
	}
	
	public Clownfish(){
		super(50,type.freshwater,"Clownfish",0);
	}
}
