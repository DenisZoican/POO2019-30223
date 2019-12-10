package test;

public class TestFacebook {
	public static void main(String[] args) {
		FacebookAccount ZoicanDenis = new FacebookAccount("Zoican Denis","Oltenia",20);
		FacebookAccount TrufinRadu = new FacebookAccount("Trufin Radu","Moldova",19);
		FacebookAccount TrifuDiana = new FacebookAccount("Trifu Diana","Deva",19);
		FacebookAccount MihutMalin = new FacebookAccount("Mihut Malin","Deva",20);
		FacebookAccount BoraVlad = new FacebookAccount("Bora Vlad","Bihor",21);
		
		ZoicanDenis.adaugaPrieten(TrufinRadu);
		ZoicanDenis.adaugaPrieten(TrifuDiana);
		ZoicanDenis.adaugaPrieten(MihutMalin);
		
		TrufinRadu.adaugaPrieten(BoraVlad);
		BoraVlad.adaugaPrieten(TrufinRadu);
		
		ZoicanDenis.arataPrieteni();
		ZoicanDenis.arataPrieteniLocatie("Deva");
		
		ZoicanDenis.stergePrieten(TrufinRadu);
		ZoicanDenis.arataPrieteni();
		
	}
}
