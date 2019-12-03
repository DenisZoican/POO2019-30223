package test;

public class TestStack {
	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		
		s.push("Ana");
		s.push("Are");
		s.push("Mere");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}
}
