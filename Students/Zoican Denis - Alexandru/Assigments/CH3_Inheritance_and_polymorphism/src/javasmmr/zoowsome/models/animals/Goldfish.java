package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.models.animals.Aquatic.type;

public class Goldfish extends Aquatic{
	public Goldfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs){
		super(avgSwimDepth,waterType,name,nrOfLegs);
	}
	
	public Goldfish(){
		super(50,type.freshwater,"Goldfish",0);
	}
}
