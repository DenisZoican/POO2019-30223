package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PetHotel {
	private Map<Integer, Dog> register_dogs;
	private String name;
	private int numberOfRooms;
	private int numberOfOccupiedRooms;
	private Map<Dog, Master> register_masters;

	public PetHotel(String name,int numberOfRooms) {
		this.setNumberOfRooms(numberOfRooms);
		this.setName(name);
		this.setRegister_dogs(new HashMap<Integer, Dog>());
		this.setRegister_masters(new HashMap<Dog, Master>());
	}

	public Integer showRoomIdForDog(Dog d) {
		for(Map.Entry<Integer, Dog> c: register_dogs.entrySet()) {
			if(c.getValue()==d) {
				return c.getKey();
			}
		}
		return -1;
	}
	public void removeRegister(Dog e) {
		Integer nr = showRoomIdForDog(e);
		if(nr==-1)
		{
			System.out.println("We don't have this dog registered. "+e.getName());
		} else {
			numberOfOccupiedRooms--;
			register_dogs.remove(nr);
			register_masters.remove(e);
		}
	}
	
	
	public void registerDog(Dog e) {
		
		if(numberOfOccupiedRooms == numberOfRooms) {
			System.out.println("No more rooms available");
			return;
		}
		
		if (e.getMaster() == null) {
			System.out.println("No master,no room!");
			return;
		}

		if (register_dogs.containsValue(e)) {
			System.out.println("This dog has already got a room. " + e.getName());
			return;
		}
		
		int room_nr = (int) (Math.random() * numberOfRooms) % numberOfRooms;
		while (register_dogs.containsKey(room_nr)) {
			room_nr = (int) (Math.random() * numberOfRooms) % numberOfRooms;
		}
		
		register_dogs.put(room_nr, e);
		register_masters.put(e, e.getMaster());
		numberOfOccupiedRooms ++;
		System.out.println("Successfully registered dog " + e.getName() + " in room " + room_nr);
	}

	
	public Map<Integer, Dog> getRegister_dogs() {
		return register_dogs;
	}

	public void setRegister_dogs(HashMap<Integer, Dog> hashMap) {
		this.register_dogs = hashMap;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Dog, Master> getRegister_masters() {
		return register_masters;
	}

	public void setRegister_masters(Map<Dog, Master> register_masters) {
		this.register_masters = register_masters;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfOccupiedRooms() {
		return numberOfOccupiedRooms;
	}

	public void setNumberOfOccupiedRooms(int numberOfOccupiedRooms) {
		this.numberOfOccupiedRooms = numberOfOccupiedRooms;
	}

}
