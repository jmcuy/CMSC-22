/*
 * A Test Driver for the Account class.
 */
public class TestAccount{
	public static void main(String[] args){
		
		//for first Constructor
		System.out.println("***FOR FIRST CONSTRUCTOR IN ACCOUNT***");
		Account ac2 = new Account(133);
		System.out.println(ac2);
		
		//Test Setters and Getters
		System.out.println("Your Account Number: " + ac2.getAccountNumber() + ", Balance: $0");
		
		//for Second Constructor
		System.out.println("***FOR SECOND CONSTRUCTOR IN ACCOUNT***");
		Account ac = new Account(123, 1000.00);
		System.out.println(ac);
		ac.setBalance(2000.00);
		System.out.println("Your Account Number is: " + ac.getAccountNumber());	
		System.out.println("Your Set Balance is: " + ac.getBalance());	
		ac.credit(1500.00);
		System.out.println("Balance with Amount Added: " + ac.getBalance());
		ac.debit(4500.00);
		System.out.println("Balance with Subtracted Amount: " + ac.getBalance());
	}
}