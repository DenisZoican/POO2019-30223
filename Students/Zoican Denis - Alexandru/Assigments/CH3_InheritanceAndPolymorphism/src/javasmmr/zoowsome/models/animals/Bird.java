package javasmmr.zoowsome.models.animals;

public class Bird extends Animal{
	Boolean migrates;
	Integer avgFlightAltitude;
	
	Bird(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs){
		super(nrOfLegs,name);
		this.migrates = migrates;
		this.avgFlightAltitude = avgFlightAltitude;
	}
}
