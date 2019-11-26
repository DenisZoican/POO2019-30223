import java.awt.Color;

public class MasinaShallow implements Cloneable {
	private String marca;
	private Color c;
	
	public MasinaShallow(String marca,Color c) {
		this.marca = marca;
		this.c = c;
	}
	
	public void schimbaCuloare (Color c) {
		this.c = c;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Color getColor() {
		return c;
	}

}
