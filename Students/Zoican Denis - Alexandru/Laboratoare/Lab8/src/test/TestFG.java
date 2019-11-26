package test;

public class TestFG {
	public void g() throws ExceptionString {
		throw new ExceptionString("Test G");
	}
	
	public void f() throws ExceptionNumber {
		try {
			this.g();
		} catch (ExceptionString e) {
			throw new ExceptionNumber(3);
		}
	}
}
