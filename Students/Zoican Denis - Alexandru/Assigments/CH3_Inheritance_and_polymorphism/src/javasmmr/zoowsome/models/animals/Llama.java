package javasmmr.zoowsome.models.animals;

public class Llama extends Mammal{
	public Llama(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs);
	}
	
	public Llama(){
		super(52,98,"Llama",new Integer(4));
	}
}
