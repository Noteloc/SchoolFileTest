import java.util.Scanner;

public class IntegerUnderFlowFixed {

	public static void main(String args[]) {
	
		int bankBalance=Integer.MIN_VALUE+10; //Set up initial bank account balance

		int withdraw=0;

		Scanner s = new Scanner(System.in);
		
		System.out.println("Initial bank balance: " + bankBalance);

		System.out.println("Enter amount to withdraw");
		withdraw = s.nextInt();
		
		try {
			//Try and withdraw money from account
			bankBalance = withdraw(bankBalance, withdraw);
		}
		catch (IllegalArgumentException ex) {
			System.out.println("*** " + ex.getMessage());
		}
		
		System.out.println("Balance after withdrawal: " + bankBalance);

	}
	
	private static int withdraw(int balance, int withdrawAmount) {

		//Check for underflow (simple version)
		if (balance<0 && balance-withdrawAmount>0) {
			throw new IllegalArgumentException("Error: integer underflow!");
		}
		
		//Otherwise, process the deposit
		return balance - withdrawAmount; //What if withdrawAmount is negative? Have we thought of that?
	}

}