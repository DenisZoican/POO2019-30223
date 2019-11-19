package zoowsome.models.animals;

public abstract class Mammal extends Animal {
	private float normalBodyTemp;
	private float percBodyHair;
	
	Mammal(float normalBodyTemp,float percBodyHair,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.normalBodyTemp = normalBodyTemp;
		this.percBodyHair = percBodyHair;
	}
	
	public float getNormalBodyTemp() {
		return this.normalBodyTemp;
	}
	
	public float getPercBodyHair() {
		return this.percBodyHair;
	}
	
	public void setNormalBodyTemp(float a) {
		this.normalBodyTemp = a;
	}
	
	public void setPercBodyHair(float a) {
		this.percBodyHair = a;
	}
}
