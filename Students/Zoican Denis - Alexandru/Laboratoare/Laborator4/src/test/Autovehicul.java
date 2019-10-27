package test;

import java.awt.Color;

public class Autovehicul{
	private String marca;
	private Color culoare;
	private int viteza;
	private int treapta;
	private int viteza_maxima;
	
	
	Autovehicul(){
		this.marca="BMW";
		this.culoare = Color.BLACK;
		this.viteza = 0;
		this.treapta = 0;
		this.viteza_maxima = 200;
	}
	
	Autovehicul(String marca,Color culoare,int viteza,int treapta,int viteza_maxima){
		this.marca = marca;
		this.culoare = culoare;
		this.viteza = viteza;
		this.treapta = treapta;
		this.viteza_maxima = viteza_maxima;
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