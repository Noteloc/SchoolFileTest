import java.util.Scanner;

public class BlackList {
    public static void main(String[] args) {
        String blacklist = ":\\"; //Don't allow DOS path symbols in input (Anything missing? What if program not run on DOS?)

        String entry = null;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter filename (no path allowed)");
        entry = s.nextLine();

        //Check if there are any DOS path symbols in the input
        boolean validEntry=true;

        for (int i=0; i<entry.length(); i++) {
            char c = entry.charAt(i);

            if (blacklist.indexOf(c)!=-1) {
                validEntry=false;
                break;
            }
        }

        //Can we use the filename as given?
        if (validEntry) {
            System.out.println("Opening file...");
        }
        else {
            System.out.println("Error in file name! Not opening file.");
        }

    }
}