import java.util.Scanner;

public class OverlyHelpful {

    public static void main(String args[]) {
        String password = null;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter your password");
        password = s.nextLine();

        //Basic validation: max password length is 4 characters
        if (password.length()>4) {
            //Let's help out, in case there are spaces at the beginning or end of the password by mistake
            password = password.trim(); //Remove any leading or trailing spaces
            password = password.substring(0,4); //Shorten the password to 4 characters, since that's the rule
        }

        //Check password
        if (password.equals("pass")) { //Valid password is "pass", but what if user enters "   password   " instead?
            System.out.println("Valid password entered");
        }
        else {
            System.out.println("INVALID PASSWORD!");
        }
        
    }


}