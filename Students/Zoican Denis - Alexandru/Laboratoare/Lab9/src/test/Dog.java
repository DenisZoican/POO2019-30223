package test;

public class Dog {
	private String name;
	private String breed;
	private Master master;
	
	public Dog(String name,String breed) {
		this.setName(name);
		this.setBreed(breed);
	}
	
	

	public void bark () {
		System.out.println("Woof!Woof! My master is "+master.getName());
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}
}
