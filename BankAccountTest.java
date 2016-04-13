// Tim Liu
// 3/8/16
// TCSS 143
// Assignment #9

// This program will test the methods written in the
// BankAccount class.

public class BankAccountTest {
	
	public static BankAccount ba;
	
	public static void main(String[] args) {
		testBankAccountConstructor(new int[] {-200,10, 200,-10, 200,10} );
		testDeposit();
		testWithdraw();
		testCalcInterest();
		testMonthlyProcess();
	}
	
	public static void testBankAccountConstructor(int[] theTestArgs) {
		for(int i = 0; i <= theTestArgs.length-2; i=i+2) {
			System.out.println(("testBankAccountConstructor : ba = new BankAccount(" + theTestArgs[i]));
			try {
				ba = new BankAccount(theTestArgs[i], theTestArgs[i+1]);
				System.out.println(ba.toString());
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		System.out.println();
	}
	
	public static void testDeposit() {
		BankAccount b = new BankAccount(1000, 1.01);
		try {
			b.deposit(-50);
		} catch  (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		
		b.deposit(100);
		System.out.println("After deposit, current balance: $" + b.getBalance() + " Deposits: " + b.getNumOfDeposits());
		
	}
	
	public static void testWithdraw() {
		System.out.println();
		BankAccount b = new BankAccount(1000, 1.01);
		try {
			b.withdraw(-50);
		} catch  (IllegalArgumentException e) {
			System.out.println(e);
		}
		System.out.println("Balance before withdraw: $" + b.getBalance());
		b.withdraw(500);
		System.out.println("After withdraw, current balance: $" + b.getBalance() + " Withdraws: " + b.getNumOfWithdraws());
		b.withdraw(480);
		System.out.println("After withdraw, current balance: $" + b.getBalance() + " Withdraws: " + b.getNumOfWithdraws());
		b.withdraw(5);
		System.out.println("After withdraw, current balance: $" + b.getBalance() + " Withdraws: " + b.getNumOfWithdraws());
		b.withdraw(20);
		System.out.println("After withdraw, current balance: $" + b.getBalance() + " Withdraws: " + b.getNumOfWithdraws());

	}
	
	public static void testCalcInterest() {
		System.out.println();
		BankAccount b = new BankAccount(1000, 5.5);
		System.out.println("Balance before interest: $" + b.getBalance());
		b.calcInterest();
		System.out.println("Balance after interest: " + b.getBalance());

	}
	
	public static void testMonthlyProcess() {
		System.out.println();
		BankAccount b = new BankAccount(1000, 5.5);
		System.out.println("Balance before interest & monthly charge: $" + b.getBalance());
		b.monthlyProcess();
		System.out.println("Balance after interest & monthly charge: $" + b.getBalance() + " Deposits: " + b.getNumOfDeposits() + " Withdraws: " + b.getNumOfWithdraws());

	}
}
