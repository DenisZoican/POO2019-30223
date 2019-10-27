package javasmmr.zoowsome.models.animals;

public class Flamingo extends Bird{
	public Flamingo(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs){
		super(migrates,avgFlightAltitude,name,nrOfLegs);
	}
	
	public Flamingo(){
		super(false,0,"Flamingo",1);
	}
}
