package javasmmr.zoowsome.models.animals;

public class Beetles extends Insect{
	public Beetles(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name){
		super(canFly,isDangerous,nrOfLegs,name);
	}
	
	public Beetles(){
		super(false,false,12,"Beetles");
	}
}
