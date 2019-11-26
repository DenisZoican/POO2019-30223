import java.awt.Color;

public class MasinaDeep implements Cloneable {
	private String marca;
	private Color c;
	
	public MasinaDeep(String marca,Color c) {
		this.marca = marca;
		this.c = c;
	}
	
	public void schimbaCuloare (Color c) {
		this.c = c;
	}

	protected Object clone() throws CloneNotSupportedException
    {
		return super.clone();
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
