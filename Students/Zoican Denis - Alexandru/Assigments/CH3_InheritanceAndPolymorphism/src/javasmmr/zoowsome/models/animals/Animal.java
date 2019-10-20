package javasmmr.zoowsome.models.animals;

public abstract class Animal {
	Integer nrOfLegs;
	String name;
	
	Animal(Integer nrOfLegs,String name)
	{
		this.name = name;
		this.nrOfLegs = nrOfLegs;
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
	
}
