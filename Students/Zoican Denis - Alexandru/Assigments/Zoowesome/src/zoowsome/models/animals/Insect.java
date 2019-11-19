package zoowsome.models.animals;

public class Insect extends Animal{
	private Boolean canFly;
	private Boolean isDangerous;
	
	Insect(Boolean canFly,Boolean isDangerous,Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.canFly = canFly;
		this.isDangerous = isDangerous;
	}
	
	public Boolean getCanFly () {
		return this.canFly;
	}
	
	public Boolean getIsDangerous() {
		return this.isDangerous;
	}
	
	public void setCanFly(Boolean a) {
		this.canFly = a;
	}
	
	public void setIsDangerous(Boolean a) {
		this.isDangerous = a;
	}
}
