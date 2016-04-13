// Tim Liu
// 3/8/16
// TCSS 143
// Assignment #9

// This program will create the subclass Savings Account which extends BankAccount class.
// The savings account cannot have a balance lower than $25.00, or the account will become
// inactive where it can no longer be withdrawn. Account will become active again once
// a deposit is made that brings the account above $25.00.


public class SavingsAccount extends BankAccount {
	
	
	// Constructor
	public SavingsAccount (double theBalance, double theInterestRate) {
		
		super(theBalance, theInterestRate);
		isActive();

	}
	
	// Returns whether the savings account is active or not,
	// checking the current balance and balance after monthly charges.
	public boolean isActive() {

		return getBalance() >= 25;

	}
	
	// Calls super method Withdraw. Withdraws only if account is active. Calls monthly process method.
	public void withdraw(double theAmount) {

		if (isActive()) {
			super.withdraw(theAmount);

			
		} else {
			throw new IllegalStateException("Withdrawals are not allowed on inactive account.");
			
		}
		isActive();
	}
	
	// Calls super method Deposit. If account is below $25 and deposit brings it
	// above $25, account becomes active again.
	public void deposit(double theAmount) {
		
		super.deposit(theAmount);
		isActive();
	}
	
	// Keeps track of withdraws, if it exceeds 4, a monthly charge of $1.00 is added
	// to the existing monthly surcharge. If balance plus monthly charges bring account
	// below 25, account becomes inactive.
	public void monthlyProcess() {
		
		setMonthlyCharge(Math.max(getNumOfWithdraws() - 4, 0));
		super.monthlyProcess();		
		isActive();

	}
	
	public String toString() {
		return super.toString() + " SavingsAccount isActive= " + isActive();
	}
	

	

}
