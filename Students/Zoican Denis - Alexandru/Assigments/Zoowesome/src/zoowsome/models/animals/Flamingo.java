package zoowsome.models.animals;

public class Flamingo extends Bird{
	public Flamingo(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(migrates,avgFlightAltitude,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Flamingo(){
		super(false,0,"Flamingo",1,6.2,0.8);
	}
}
