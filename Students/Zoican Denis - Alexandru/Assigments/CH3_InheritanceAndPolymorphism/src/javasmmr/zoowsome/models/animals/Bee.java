package javasmmr.zoowsome.models.animals;

public class Bee extends Insect{
	public Bee(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name){
		super(canFly,isDangerous,nrOfLegs,name);
	}
	
	public Bee(){
		super(true,true,8,"Bee");
	}
}
