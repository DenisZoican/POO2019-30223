package zoowsome.models.animals;

import zoowsome.models.animals.Aquatic.type;

public class Goldfish extends Aquatic{
	public Goldfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(avgSwimDepth,waterType,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Goldfish(){
		super(50,type.freshwater,"Goldfish",0,1.0,0.006);
	}
}
