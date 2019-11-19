package zoowsome.models.animals;

public class Clownfish extends Aquatic {
	
	public Clownfish(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(avgSwimDepth,waterType,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Clownfish(){
		super(50,type.freshwater,"Clownfish",0,5.4,0.02);
	}
}
