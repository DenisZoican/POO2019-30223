package javasmmr.zoowsome.models.animals;

public class Peacock extends Bird{
	public Peacock(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs){
		super(migrates,avgFlightAltitude,name,nrOfLegs);
	}
	
	public Peacock(){
		super(false,0,"Peacock",2);
	}
}
