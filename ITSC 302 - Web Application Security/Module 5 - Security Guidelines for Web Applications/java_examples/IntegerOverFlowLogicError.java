import java.util.Scanner;

public class IntegerOverFlowLogicError {

	public static void main(String args[]) {
	
		int bankBalance=Integer.MAX_VALUE-10; //Set up initial bank account balance
		
		int deposit=0;
		int withdraw=0;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Initial bank balance: " + bankBalance);

		System.out.println("Enter amount to deposit");
		deposit = s.nextInt();
		
		bankBalance = bankBalance + deposit;
		System.out.println("Balance after deposit: " + bankBalance);

		
		System.out.println("Enter amount to withdraw");
		withdraw = s.nextInt();
		
		if (bankBalance<0) {
			System.out.println("You are not allowed to transact on an overdrawn account!");
		}
		else {
			bankBalance = bankBalance - withdraw;
			System.out.println("Balance after withdrawal: " + bankBalance);
		}
	
	
	}

}