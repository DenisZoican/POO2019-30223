package zoowsome.models.animals;

public class Llama extends Mammal{
	public Llama(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs,maintenanceCost,dangerPerc);
	}
	
	public Llama(){
		super(52,98,"Llama",new Integer(4),7.6,0.2);
	}
}
