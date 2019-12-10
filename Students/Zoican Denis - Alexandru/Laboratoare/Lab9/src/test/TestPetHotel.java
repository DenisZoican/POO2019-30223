package test;

public class TestPetHotel {

	public static void main(String[] args) {
		PetHotel petHotel = new PetHotel("Hanu' Osesc",29);
		
		Dog d1 = new Dog("Lupu'","Ciobanesc");
		Dog d2 = new Dog("Pali","Labrador");
		Dog d3 = new Dog("Rex","Bulldog");
		Dog d4 = new Dog("Brutus","Pomerian");
		Dog d5 = new Dog("Fifi","Poodle");
		
		Master m1 = new Master("Zoican",20);
		Master m2 = new Master("Alexandru",19);
		
		m1.addDog(d1);
		m1.addDog(d2);
		m1.addDog(d3);
		
		m2.addDog(d4);
		m2.addDog(d5);
		
		
		petHotel.registerDog(d1);
		petHotel.registerDog(d2);
		petHotel.registerDog(d3);
		petHotel.registerDog(d4);
		petHotel.registerDog(d5);
		
		petHotel.removeRegister(d1);
		petHotel.removeRegister(d1);
		
		
		System.out.println("The room where "+d2.getName()+" stays is room nr "+petHotel.showRoomIdForDog(d2));
		System.out.println("The room where "+d1.getName()+" stays is room nr "+petHotel.showRoomIdForDog(d1));
		
		m1.showDogs();
	}

}
