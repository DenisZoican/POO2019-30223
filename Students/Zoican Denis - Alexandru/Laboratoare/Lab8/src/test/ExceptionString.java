package test;

public class ExceptionString extends Exception{
	private String msg;
	public ExceptionString() {};
	public ExceptionString(String msg) {
		super(msg);
		this.setMsg(msg);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
