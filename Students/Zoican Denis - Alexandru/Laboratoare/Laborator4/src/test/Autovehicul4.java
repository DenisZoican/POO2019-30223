package test;

import java.awt.Color;

public class Autovehicul4 extends Inventie{
	
	public final boolean poluare = true;
	private String marca;
	private Color culoare;
	private int viteza;
	private int treapta;
	private int viteza_maxima;
	public Sofer sofer;
	
	Autovehicul4(){
		super();
		this.marca="BMW";
		this.culoare = Color.BLACK;
		this.viteza = 0;
		this.treapta = 0;
		this.viteza_maxima = 200;
		this.sofer = new Sofer("Zoican","Denis",20,1);
	}
	
	Autovehicul4(String marca,Color culoare,int viteza,int treapta,int viteza_maxima,Sofer sofer){
		super();
		this.marca = marca;
		this.culoare = culoare;
		this.viteza = viteza;
		this.treapta = treapta;
		this.viteza_maxima = viteza_maxima;
		this.sofer = sofer;
	}
	
	public String getMarca()
	{
		return marca;
	}
	
	public Color getCuloare()
	{
		return culoare;
	}
	
	public int getTreapta()
	{
		return treapta;
	}
	
	public int getViteza()
	{
		return viteza;
	}
	
	public int getVitezaMaxima()
	{
		return viteza_maxima;
	}
	
	
	public void accelerare(int v) {
		if(viteza+v<=viteza_maxima)
		viteza+=v;
	}
	
	public void accelerare() {
		if(viteza+1<=viteza_maxima)
			viteza+=1;
	}
	
	public void decelerare(int v) {
		if(viteza-v>0)
		viteza-=v;
	}
	
	public void schimbareTreapta(int t)
	{
		treapta=t;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public void setCuloare(Color culoare)
	{
		this.culoare = culoare;
	}
	
	public void setTreapta(int treapta)
	{
		this.treapta = treapta;
	}
	
	public void setViteza(int viteza)
	{
		this.viteza = viteza;
	}
	
	public void setVitezaMaxima(int vitezaMaxima)
	{
		this.viteza_maxima = vitezaMaxima;
	}
	
	public void oprire() {
		viteza=0;
	}
}
