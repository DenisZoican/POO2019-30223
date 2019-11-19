package zoowsome.models.animals;

public class Peacock extends Bird{
	public Peacock(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(migrates,avgFlightAltitude,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Peacock(){
		super(false,0,"Peacock",2,5.5,0.3);
	}
}
