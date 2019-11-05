package javasmmr.zoowsome.models.animals;

public class Bird extends Animal{
	private Boolean migrates;
	private Integer avgFlightAltitude;
	
	Bird(Boolean migrates,Integer avgFlightAltitude,String name,Integer nrOfLegs){
		super(nrOfLegs,name);
		this.migrates = migrates;
		this.avgFlightAltitude = avgFlightAltitude;
	}
	
	public Boolean getMigrates() {
		return this.migrates;
	}
	
	public Integer getAvgFlightAltitude() {
		return this.avgFlightAltitude;
	}
	
	public void setMigrates (Boolean a) {
		this.migrates = a;
	}
	
	public void setAvgFlightAltitude(Integer a) {
		this.avgFlightAltitude = a;
	}
	
	
}
