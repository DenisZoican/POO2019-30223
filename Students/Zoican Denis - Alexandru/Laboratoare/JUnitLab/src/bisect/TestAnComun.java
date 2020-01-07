package bisect;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class TestAnComun {
	
	@Test
	public void test() {
		AnBisect ab = new AnBisect();

		assertFalse(ab.esteAnBisect(203));
		assertFalse(!ab.esteAnBisect(4));
		assertFalse(ab.esteAnBisect(99));
		assertFalse(ab.esteAnBisect(100));
		assertFalse(ab.esteAnBisect(200));
		assertFalse(!ab.esteAnBisect(400));
		assertFalse(ab.esteAnBisect(500));
		assertFalse(ab.esteAnBisect(1000));
		assertFalse(!ab.esteAnBisect(1600));
		assertFalse(ab.esteAnBisect(2018));
	}
}
