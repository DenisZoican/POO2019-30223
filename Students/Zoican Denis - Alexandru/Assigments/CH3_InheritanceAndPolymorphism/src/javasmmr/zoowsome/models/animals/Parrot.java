package javasmmr.zoowsome.models.animals;

public class Parrot extends Bird{
	
	public Parrot(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs){
		super(migrates,avgFlightAltitude,name,nrOfLegs);
	}
	
	public Parrot(){
		super(false,5,"Parrot",2);
	}
}
