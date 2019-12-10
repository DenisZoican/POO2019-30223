package test;
import java.util.ArrayList;

public class Master {
	private String name;
	private ArrayList<Dog> dogs;
	private int age;
	
	public Master (String name,int age) {
		this.setName(name);
		this.setAge(age);
		this.setDogs(new ArrayList<Dog>());
	}

	public void addDog(Dog d) {
		if(d.getMaster()!=null)
			System.out.println("This dog has a master ."+d.getName());
		else
			{
			dogs.add(d);
			d.setMaster(this);
			}
	}
	
	public void showDogs() {
		System.out.println(name+" has "+dogs.size()+" dogs.");
		for(Dog c:dogs) {
			System.out.println(c.getName());
		}
		System.out.println();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Dog> getDogs() {
		return dogs;
	}

	public void setDogs(ArrayList<Dog> dogs) {
		this.dogs = dogs;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
