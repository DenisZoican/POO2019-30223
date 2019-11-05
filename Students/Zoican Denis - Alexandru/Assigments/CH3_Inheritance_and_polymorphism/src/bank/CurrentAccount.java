package bank;

public class CurrentAccount extends Account{

	private int overdraft;
	public CurrentAccount(int number,int overdraft) {
		super(number);
		this.overdraft = overdraft;
	}
	
	public String toString() {
		return "CurrentAccount " + getAccountNumber() + ": " + "balance = " + getBalance();
	}
	
	public int getOverdraft() {
		return overdraft;
	}
	
	public void setOverdraft(int a) {
		this.overdraft = a;
	}
	
	
}
