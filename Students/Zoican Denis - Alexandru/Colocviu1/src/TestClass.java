import java.util.Date;

public class TestClass {
	
	public static void main(String[] args) {
		
		///Verificare clienti
		Client client1 = new Client(1,"Zoican");
		Client client2 = new Client(2,"Alexandru");
		Client client3 = new Client(12,"Diana");
		Produs paine = new Produs("Paine",2.5,2);
		Produs oua = new Produs("Oua",2.5,3);
		Produs lapte = new Produs("Lapte",2.5,1);
		
	
		System.out.println("--------- Verificam daca am introdus corect produsele in clienti ----------\n");
		System.out.println("Mai sunt oua?:"+oua.verificareStoc());
		client2.adaugaProdus(lapte);
		
		client1.adaugaProdus(paine);
		client1.adaugaProdus(oua);
		client1.adaugaProdus(paine);
		
		System.out.println("\n---------- O sa afisam clientul1 ---------- \n");
		System.out.println(client1);
		
		///Verificare clientiFideli
		System.out.println("---------- O sa afisam clientul fidel ---------- \n");
		ClientFidel clientFidel1 = new ClientFidel(2,"Denis");
		ClientFidel clientFidel2 = new ClientFidel(23,"ZoicanDenis");
		clientFidel1.adaugaProdus(oua);
		clientFidel1.adaugaProdus(oua);
		System.out.println(clientFidel1);
		
		
		///Verificare angajat
		Angajat angajat1 = new Angajat(3, "Marius",new Date());
		System.out.println("---------- O sa verificam daca serveste corect clientul1 ---------- \n");
		System.out.println("Client1 a cumparat "+angajat1.servireClient(client1));
		
		
		angajat1.servireClient(client1);
		angajat1.servireClient(client2);
		System.out.println("---------- O sa afisam angajatul1 ---------- \n");
		System.out.println(angajat1);
		
		Angajat angajat2 = new Angajat(4, "Daniel",new Date());
		angajat1.servireClient(client1);
		
		Angajat angajat3 = new Angajat(5, "Radu",new Date());
		angajat3.servireClient(client1);
		angajat3.servireClient(client2);
		angajat3.servireClient(client3);
		
		///Verificare supermarket
		Supermarket supermarket = new Supermarket();
		supermarket.adaugaAngajat(angajat1);
		supermarket.adaugaAngajat(angajat2);
		supermarket.adaugaAngajat(angajat3);
		supermarket.adaugaClientFidel(clientFidel1);
		supermarket.adaugaClientFidel(clientFidel2);
		supermarket.adaugaClient(client1);
		supermarket.adaugaClient(client2);
		///Afisam angajatii din supermarket
		System.out.println("---------- O sa afisam angajatii ---------- \n");
		supermarket.arataAngajati();
		
		System.out.println("---------- O sa afisam clientii ---------- \n");
		supermarket.arataClientiFideli();
		System.out.println("---------- O sa afisam statistici ---------- \n");
		supermarket.arataStatistici();
		
		
		
	}

}
