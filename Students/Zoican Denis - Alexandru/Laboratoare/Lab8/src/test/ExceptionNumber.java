package test;

public class ExceptionNumber extends Exception{
	private Integer number;
	public ExceptionNumber() {};
	public ExceptionNumber(Integer number) {
		this.number = number;
	}
	
	public Integer getNumber() {
		return this.number;
	}
}
