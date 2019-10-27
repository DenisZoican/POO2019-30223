package javasmmr.zoowsome.models.animals;

public class Spider extends Insect{
	public Spider(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name){
		super(canFly,isDangerous,nrOfLegs,name);
	}
	
	public Spider(){
		super(false,true,8,"Bee");
	}
}
