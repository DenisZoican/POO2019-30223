package bank;

public class SavingAccount extends Account{
	
	private int interest;
	public SavingAccount(int number,int interest) {
		super(number);
		this.interest = interest;
	}
	
	public String toString() {
		return "SavingAccount " + getAccountNumber() + ": " + "balance = " + getBalance();
	}
	
	public void addInterest() {
		deposit(interest);
	}
	
	public int getInterest()
	{
		return this.getInterest();
	}
	
	public void setInterest(int a) {
		this.interest = a;
	}
}
