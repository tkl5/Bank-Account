// Tim Liu
// 3/8/16
// TCSS 143
// Assignment #9

// This program will create a superclass bank account where the user can
// deposit and withdraw money with monthly service charges and interest. 

public class BankAccount {
	
	private double myBalance;
	private int myNumOfDeposits;
	private int myNumOfWithdraws;
	private double myAnnInterestRate;
	private double myMonthlyCharges;
	
	// Constructor
	public BankAccount(double theBalance, double theAnnInterestRate) {
		
		if (theBalance < 0 || theAnnInterestRate < 0) {
			throw new IllegalArgumentException("Balance or interest rate cannot be negative.");
		}
		
		myBalance = theBalance;
		myAnnInterestRate = theAnnInterestRate;
	}
	

	// Deposits money, keeps track of number of deposits
	public void deposit(double theAmount) {
		
		if (theAmount < 0) {
			throw new IllegalArgumentException("Deposit cannot be negative");
		}
		myBalance += theAmount;
		myNumOfDeposits++;
	}
	
	// Withdraws money, keeps track of number of withdraws.
	public void withdraw(double theAmount) {
		
		if (theAmount < 0 || myBalance < 0) {
			throw new IllegalArgumentException("Withdrawal cannot be negative");
		
		} 
		
		myBalance -= theAmount;
		myNumOfWithdraws++;
		
	}
	
	// Calculates interest
	public void calcInterest() {
		
		myBalance += myBalance * (myAnnInterestRate / 1200.0);
		
	}
	
	// Subtracts any monthly charges from the current balance along with interest.
	// Resets counts
	public void monthlyProcess() {
		
		myBalance -= myMonthlyCharges;
		calcInterest();
		myNumOfWithdraws = 0;
		myNumOfDeposits = 0;
		myMonthlyCharges = 0;
	}
	
	// Method to help keep track of additional ($1) charges.
	protected void setMonthlyCharge(double charges) {
		myMonthlyCharges = charges;
	}
	
	public String toString() {
		return ("BankAccount myBalance = " + myBalance + " myDepositCount = " + myNumOfDeposits + 
				" myWithdrawalCount= " + myNumOfDeposits);
	}
	
	// Getters
	public double getBalance() {
		return myBalance;
	}
	
	public int getNumOfDeposits() {
		return myNumOfDeposits;
	}
	
	public int getNumOfWithdraws() {
		return myNumOfWithdraws;
	}
	
	public double getMonthlyCharges() {
		return myMonthlyCharges;
	}
	

}
