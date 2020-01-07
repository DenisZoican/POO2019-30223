package bisect;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAnBisect{

	@Test
	public void test() {
		AnBisect ab = new AnBisect();

		assertTrue(!ab.esteAnBisect(203));
		assertTrue(ab.esteAnBisect(4));
		assertTrue(!ab.esteAnBisect(99));
		assertTrue(!ab.esteAnBisect(100));
		assertTrue(!ab.esteAnBisect(200));
		assertTrue(ab.esteAnBisect(400));
		assertTrue(!ab.esteAnBisect(500));
		assertTrue(!ab.esteAnBisect(1000));
		assertTrue(ab.esteAnBisect(1600));
		assertTrue(!ab.esteAnBisect(2018));
	}
}