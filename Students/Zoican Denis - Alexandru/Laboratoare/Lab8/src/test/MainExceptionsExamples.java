package test;

public class MainExceptionsExamples {
	public static void main(String[] args) {

		/// NullPointerException example
		try {
			Lucrator l = null;
			l.getNume();
		} catch (NullPointerException e) {
			System.out.println(e);
		}

		/// ArraylndexOutOfBoundsException example
		try {
			int a[] = new int[50];
			a[50]=2;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		/// Throws exception inside try catch
		try {
			throw new Exception("ExceptieTest");
		}catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("ExceptieTest finally");
		}
		
		/// Example of my Exception class
		
		try {
			ExceptionString exc = new ExceptionString("Warning");
			System.out.println(exc.getMsg());
			throw exc;
		} catch (ExceptionString e) {
			System.out.println(e.getMessage());
		}
		
		/// Example of class with f and g methods
		
		TestFG fg = new TestFG();
		try {
			fg.f();
		} catch (ExceptionNumber e) {
			System.out.println(e.getNumber());
		}

	}
}
