package zoowsome.models.animals;

public class Catfish extends Aquatic{
	public Catfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(avgSwimDepth,waterType,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Catfish(){
		super(150,type.saltwater,"Catfish",0,1.3,0.05);
	}
}
