/**
 * By Jhessa Mae Uy
  */
public class Account{
	private int accountNumber;
	private double balance = 0.0;

	
	public Account(){

	}
	public Account(int accountNum){
		this.accountNumber= accountNum;
	}
	
	public Account(int accountNum, double amount){
		this.accountNumber = accountNum;
		this.balance = amount;
	}

	public int getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}

	public void setBalance(double balance){
		if(balance < 0){
			throw new IllegalArgumentException("Amount Set cannot be negative!");
		}	
		this.balance = balance;
	}
	public void credit(double amount){
		if(amount < 0){
			throw new IllegalArgumentException("Amount added cannot be negative!");
		}
		this.balance += amount;
	}
	
	public void debit(double amount){
		if(amount > balance){
			throw new IllegalArgumentException("Amount Withdrawn Cannot Exceed Balance!");
		} else if(balance < 0){
			throw new IllegalArgumentException("Amount added cannot be negative!");
		} else {
		//do  nothing
		}
		this.balance = this.balance - amount;
	}

	public String toString(){
		return String.format("A/C no:%03d, Balance=$%.2f", accountNumber, balance);
	}
}