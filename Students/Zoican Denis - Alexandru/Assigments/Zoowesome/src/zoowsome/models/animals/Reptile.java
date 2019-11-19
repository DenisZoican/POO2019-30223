package zoowsome.models.animals;

public abstract class Reptile extends Animal{
	private Boolean layEggs;
	
	Reptile(boolean layEggs,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.layEggs = layEggs;
	}
	
	public Boolean getLayEggs() {
		return this.layEggs;
	}
	
	public void setLayEggs(Boolean a) {
		this.layEggs = a;
	}
	
	
}
