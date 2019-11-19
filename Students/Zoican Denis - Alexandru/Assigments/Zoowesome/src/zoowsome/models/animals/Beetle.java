package zoowsome.models.animals;

public class Beetle extends Insect{
	public Beetle(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc){
		super(canFly,isDangerous,nrOfLegs,name,maintenanceCost,dangerPerc);
	}
	
	public Beetle(){
		super(false,false,12,"Beetles",3,0.3);
	}
}
