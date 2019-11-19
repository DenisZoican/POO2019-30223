package zoowsome.models.animals;

public class Bear extends Mammal{
	
	public Bear(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Bear(){
		super(42,80,"Bear",new Integer(4),2.3,0.8);
	}
	

}
