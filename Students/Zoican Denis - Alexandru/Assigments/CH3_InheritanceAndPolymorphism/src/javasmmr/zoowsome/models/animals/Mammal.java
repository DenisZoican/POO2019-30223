package javasmmr.zoowsome.models.animals;

public abstract class Mammal extends Animal {
	float normalBodyTemp;
	float percBodyHair;
	
	Mammal(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs){
		super(nrOfLegs,name);
		this.normalBodyTemp = normalBodyTemp;
		this.percBodyHair = percBodyHair;
	}
}
