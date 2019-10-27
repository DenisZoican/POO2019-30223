package javasmmr.zoowsome.models.animals;

public class Cow extends Mammal{
	public Cow(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs){
		super(normalBodyTemp,percBodyHair,name,nrOfLegs);
	}
	
	public Cow(){
		super(42,95,"Cow",new Integer(4));
	}
}
