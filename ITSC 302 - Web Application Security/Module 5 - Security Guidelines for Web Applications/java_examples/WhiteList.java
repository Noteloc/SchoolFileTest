import java.util.Scanner;

public class WhiteList {
    public static void main(String args[]) {

        String whitelistChars = "0123456789"; //This is the white list of acceptable characters

        String entry = null;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a numeric digit, 0-9");
        entry = s.nextLine();

        //Check if entry is valid (It's a single character that's in the whitelist)
        if (entry.length()>1 || whitelistChars.indexOf(entry)==-1) {
            System.out.println("You did not enter a valid numeric digit!");
        }
        else {
            System.out.println("You entered " + entry);
        }
    }
}