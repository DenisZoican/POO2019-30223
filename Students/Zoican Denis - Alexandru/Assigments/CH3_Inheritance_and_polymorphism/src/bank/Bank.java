package bank;

public class Bank {
	private Account[] accounts = null;
	private int numberOfAccounts = 0;
	private int total = 0;
	
	Bank(int number){
		this.total = number;
		this.accounts = new Account[number];
	} 
	
	public void update() {
		for(int i=0;i<numberOfAccounts;i++)
		{
			if(accounts[i] instanceof SavingAccount)
				((SavingAccount)accounts[i]).addInterest();
			else if(accounts[i] instanceof CurrentAccount)
				if((-1)*accounts[i].getBalance() > ((CurrentAccount)accounts[i]).getOverdraft())
					System.out.println("Account "+accounts[i].getAccountNumber()+" is in overdraft.");
		}
	}
	
	public Account[] getAccounts() {
		return this.accounts;
	}
	
	public int getNumberOfAccounts() {
		return this.numberOfAccounts;
	}
	
	public int getTotal() {
		return this.total;
	}
	
	public void addAccount(Account a) {
		if(numberOfAccounts<total)
		{
		accounts[numberOfAccounts] = a;
		numberOfAccounts++;
		} else {
			System.out.println("Failed! Max number of accounts!\n");
		}
	}
	
	public void closeAccount(int number) {
		for(int i=0;i<numberOfAccounts;i++) {
			if(number==accounts[i].getAccountNumber()) {
				{
				accounts[i] = accounts[numberOfAccounts-1];
				numberOfAccounts--;
				return;
				}
			}
		}
		
		System.out.println("Failed!This account doesn't exist.");
	}
	
	public void payDivident(int sum) {
		for(int i=0;i<numberOfAccounts;i++) {
			accounts[i].deposit(sum);
		}
	}
}
