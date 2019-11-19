package zoowsome.models.animals;

public class Parrot extends Bird{
	
	
	public Parrot(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(migrates,avgFlightAltitude,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Parrot(){
		super(false,5,"Parrot",2,5.4,0.5);
	}
}
