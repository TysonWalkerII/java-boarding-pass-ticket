package BoardingPassIO;

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
        System.out.println("Pass: " + passNum);
        return passNum.toString();
    }
}