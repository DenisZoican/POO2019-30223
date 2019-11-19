package zoowsome.models.animals;

public class Bee extends Insect{
	public Bee(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc){
		super(canFly,isDangerous,nrOfLegs,name,maintenanceCost,dangerPerc);
	}
	
	public Bee(){
		super(true,true,8,"Bee",2.2,0.67);
	}
}
