package zoowsome.models.animals;

public abstract class Animal implements Killer{
	private final double maintenanceCost;
	private final double dangerPerc;
	private Integer nrOfLegs;
	private String name;
	private boolean takenCareOf;
	
	
	Animal(Integer nrOfLegs,String name,double maintenanceCost,double dangerPerc)
	{
		this.dangerPerc = dangerPerc;
		this.maintenanceCost = maintenanceCost;
		this.name = name;
		this.nrOfLegs = nrOfLegs;
	}
	
	public double getPredisposition() {
		return 0;
	}
	
	public boolean kill() {
		double nr_r = Math.random();
		if(nr_r<dangerPerc+getPredisposition()) {
			return true;
		}
		return false;
	}
	
	public Integer getNrOfLegs()
	{
		return nrOfLegs;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setNrOfLegs(Integer nrOfLegs)
	{
		this.nrOfLegs = nrOfLegs;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public boolean isTakenCareOf() {
		return takenCareOf;
	}

	public void setTakenCareOf(boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}
	
}
