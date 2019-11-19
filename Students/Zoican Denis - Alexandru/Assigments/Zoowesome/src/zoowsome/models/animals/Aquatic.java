package zoowsome.models.animals;

public abstract class Aquatic extends Animal{
	public enum type {
		    saltwater,
		    freshwater
		  }
	private Integer avgSwimDepth;
	private type waterType;
	
	Aquatic(Integer avgSwimDepth,type waterType,String name,Integer nrOfLegs,double maintenanceCost,double dangerPerc){
		super(nrOfLegs,name,maintenanceCost,dangerPerc);
		this.avgSwimDepth = avgSwimDepth;
		this.waterType = waterType;
	}
	
	public Integer getAvgSwimDepth() {
		return this.avgSwimDepth;
	}
	
	public type getTaterType() {
		return this.waterType;
	}
	
	public void setAvgSwimDepth(Integer a) {
		this.avgSwimDepth = a;
	}
	
	public void setWaterType(type a) {
		this.waterType = a;
	}
}
