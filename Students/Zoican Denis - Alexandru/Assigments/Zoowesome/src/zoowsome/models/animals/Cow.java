package zoowsome.models.animals;

public class Cow extends Mammal{
	public Cow(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Cow(){
		super(42,95,"Cow",new Integer(4),4,0.8);
	}
}
