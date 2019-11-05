package bank;
import org.junit.Assert;
import org.junit.Test;


public class TestBank {

	@Test
	public void test() {
		
		Bank b = new Bank(5);
		
		b.addAccount(new SavingAccount(1,20));
		b.addAccount(new CurrentAccount(2,30));
		b.addAccount(new SavingAccount(3,40));
		b.addAccount(new CurrentAccount(4,50));
		
		b.getAccounts()[0].deposit(20);
		b.getAccounts()[1].deposit(30);
		((SavingAccount)b.getAccounts()[2]).addInterest();
		b.getAccounts()[3].withdraw(60);
		
		b.update();
		
		b.payDivident(20);
		
		Assert.assertTrue(b.getAccounts()[0].getBalance()==60);
		Assert.assertTrue(b.getAccounts()[1].getBalance()==50);
		Assert.assertTrue(b.getAccounts()[2].getBalance()==100);
		Assert.assertTrue(b.getAccounts()[3].getBalance()== -40);
		
		b.closeAccount(3);
		
		boolean ok = true;
		for(int i=0;i<b.getNumberOfAccounts();i++)
		{
			if(b.getAccounts()[i].getAccountNumber()==3) {
				ok = false;
				break;
			}
		}
		
		Assert.assertTrue(ok == true && b.getNumberOfAccounts()==3);
		
		
		b.addAccount(new SavingAccount(5,20));
		b.addAccount(new SavingAccount(6,20));
		b.addAccount(new SavingAccount(7,20));
		b.addAccount(new SavingAccount(8,20));
		b.addAccount(new SavingAccount(9,20));
		
		b.closeAccount(10);
	}

}
