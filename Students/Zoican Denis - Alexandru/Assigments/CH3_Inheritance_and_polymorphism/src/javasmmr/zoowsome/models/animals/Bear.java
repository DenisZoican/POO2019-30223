package javasmmr.zoowsome.models.animals;

public class Bear extends Mammal{
	
	public Bear(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs);
	}
	
	public Bear(){
		super(42,80,"Bear",new Integer(4));
	}
	

}
