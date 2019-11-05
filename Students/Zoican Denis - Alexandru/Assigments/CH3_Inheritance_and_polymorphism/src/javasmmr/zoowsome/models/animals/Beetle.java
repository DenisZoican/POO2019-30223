package javasmmr.zoowsome.models.animals;

public class Beetle extends Insect{
	public Beetle(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name){
		super(canFly,isDangerous,nrOfLegs,name);
	}
	
	public Beetle(){
		super(false,false,12,"Beetles");
	}
}
