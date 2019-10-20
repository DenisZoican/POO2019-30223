package javasmmr.zoowsome.models.animals;

import javasmmr.zoowsome.models.animals.Aquatic.type;

public class Catfish extends Aquatic{
	public Catfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs){
		super(avgSwimDepth,waterType,name,nrOfLegs);
	}
	
	public Catfish(){
		super(150,type.saltwater,"Catfish",0);
	}
}
