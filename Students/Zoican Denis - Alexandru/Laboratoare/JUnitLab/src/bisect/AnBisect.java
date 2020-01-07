package bisect;

public class AnBisect {
	public boolean esteAnBisect(int an) {
		if ((an % 4 == 0) && (an % 100 != 0))
			return true;
		if (an % 400 == 0)
			return true;
		return false;
	}
}
