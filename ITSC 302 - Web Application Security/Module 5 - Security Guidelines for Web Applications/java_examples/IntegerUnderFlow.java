import java.util.Scanner;

public class IntegerUnderFlow {

	public static void main(String args[]) {
	
		int bankBalance=Integer.MIN_VALUE+10; //Set up initial bank account balance

		int withdraw=0;

		Scanner s = new Scanner(System.in);
		
		System.out.println("Initial bank balance: " + bankBalance);

		System.out.println("Enter amount to withdraw");
		withdraw = s.nextInt();

		bankBalance = bankBalance - withdraw; 

		System.out.println("Balance after withdrawal: " + bankBalance);

	}
	

}