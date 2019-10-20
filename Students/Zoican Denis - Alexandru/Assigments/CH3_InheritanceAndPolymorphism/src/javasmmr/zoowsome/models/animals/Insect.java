package javasmmr.zoowsome.models.animals;

public class Insect extends Animal{
	Boolean canFly;
	Boolean isDangerous;
	
	Insect(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name){
		super(nrOfLegs,name);
		this.canFly = canFly;
		this.isDangerous = isDangerous;
	}
}
