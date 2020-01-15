package Colocviu;

public class PairAngajat implements Cloneable {
	private Angajat ang;
	private Integer nr_ret;

	public PairAngajat(Angajat ang, Integer nr_ret) {
		this.ang = ang;
		this.nr_ret = nr_ret;
	}

	public Object clone() throws CloneNotSupportedException {
		PairAngajat s = (PairAngajat) super.clone();
		s.ang = (Angajat) ang.clone();
		return s;
	}

	public Angajat getAng() {
		return ang;
	}

	public void setAng(Angajat ang) {
		this.ang = ang;
	}

	public Integer getNr_ret() {
		return nr_ret;
	}

	public void setNr_ret(Integer nr_ret) {
		this.nr_ret = nr_ret;
	}

}
