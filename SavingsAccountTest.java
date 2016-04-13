// Tim Liu
// 3/8/16
// TCSS 143
// Assignment #9

// This program will test the methods written in the
// SavingsAccount subclass.

public class SavingsAccountTest {
	
	public static SavingsAccount sa;
	
	public static void main(String[] args) {

		testSavingsAccountConstructor(new int[] {-200,10, 200,-10 , 200,10 , 20,12} );
		testWithdraw(new double[] {-20, 0, 80, 10} );
		testDeposit(new double[] {-200.0, 5, 200.0} );
		testMonthlyProcess();
	}
	public static void testSavingsAccountConstructor(int[] theTestArgs) {
		for(int i = 0; i <= theTestArgs.length-2; i=i+2) {
			System.out.println(("testSavingsAccountConstructor : sa = new SavingsAccount(" + theTestArgs[i]));
			try {
				sa = new SavingsAccount(theTestArgs[i], theTestArgs[i+1]);
				System.out.println(sa.toString());
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		System.out.println();
	}
	
	public static void testWithdraw(double[] theTestArgs) {
		sa = new SavingsAccount(100.0, 10);
		System.out.println("theTestSavingsAccountWithdraw : " + sa.toString());
		for (int i = 0; i < theTestArgs.length-1; i=i+1) {
			System.out.println("testSavingsAccountWithdraw : sa.withdraw(" + theTestArgs[i]);
			try {
				sa.withdraw(theTestArgs[i]);
				System.out.println(sa.toString());
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		System.out.println();

	}
	
	public static void testDeposit(double[] theTestArgs) {
		sa = new SavingsAccount(0, 12);
		System.out.println("theTestSavingsAccountDeposit : " + sa.toString());
		for (int i = 0; i < theTestArgs.length-1; i=i+1) {
			System.out.println("testSavingsAccountDepositw : sa.deposit(" + theTestArgs[i]);
			try {
				sa.deposit(theTestArgs[i]);
				System.out.println(sa.toString());
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		}
		System.out.println();

	}
	
	public static void testMonthlyProcess() {
		sa.deposit(95);
		System.out.println("testSavingsAccountMonthlyProcess : before " + sa.toString());
		sa.monthlyProcess();
		System.out.println("testSavingsAccountMonthlyProcess : after sa.monthlyProcess " + sa.toString());
		System.out.println();
		
		sa = new SavingsAccount(26, 12);
		sa.withdraw(0);
		sa.withdraw(0);
		sa.withdraw(0);
		sa.withdraw(0);
		sa.withdraw(0);
		sa.withdraw(0);
		System.out.println("testSavingsAccountMonthlyProcess : before " + sa.toString());
		sa.monthlyProcess();
		System.out.println("testSavingsAccountMonthlyProcess : after sa.monthlyProcess " + sa.toString());

	}
}
