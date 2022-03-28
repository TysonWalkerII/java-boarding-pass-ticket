package BoardingPassIO;

import java.io.File;
import java.util.*;

public class PassNumber {
    static PassNumber passString = new PassNumber();
    private static final String ALPHANUMERIC = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"; // Took out easily-confused characters 0-O, 1-I

    public static void main(String[] args){
        passString.passNumber();
    }
    public String passNumber() {
        long seed = System.currentTimeMillis(); // Using currentTimeMillis generates a 12-digit number, that ideally makes a seed that won't result in any duplicate random numbers
        Random rand = new Random(seed);
        int passLength = 15;
        StringBuilder passNum = new StringBuilder(); // Mutable, and more memory efficient than using String
        for (int i = 0; i <= passLength; i++) {
            int randIndex = rand.nextInt(ALPHANUMERIC.length());
            passNum.append(ALPHANUMERIC.charAt(randIndex));
        }
        System.out.println("Pass: " + passNum); // Just to check that it's returning a value;
        return passNum.toString();
    }

    public String isDuplicate(String passNum){
        // Import file from location
        // for loop iterate through the pass number values, looking for duplicates
        // if duplicate found, re-run passNumber()
        // otherwise, return passNum to be written to the appropriate entry
    }
}