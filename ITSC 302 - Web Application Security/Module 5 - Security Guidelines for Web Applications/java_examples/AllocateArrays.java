import java.util.Scanner;
import java.io.IOException;

public class AllocateArrays {

	public static void main(String args[]) {
		int numArrays=0;
		Scanner s = new Scanner(System.in);
		int[][] intArrays = new int[1000000][];
		
		//Windows 10: java.lang.OutOfMemoryError will be thrown if user enters a large number...
		System.out.println("Enter number of arrays to allocate");
		numArrays=s.nextInt();
		
		int count=0;
		
		while (count<numArrays) {
			intArrays[count] = new int[100000];
			
			count++;
			
			if (count%10==0) {
				System.out.println("Allocated: " + count);
			}
		}
		
		//Garbage collector will deallocate when program finishes.
	}

}