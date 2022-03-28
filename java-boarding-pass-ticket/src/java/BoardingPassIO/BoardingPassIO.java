package BoardingPassIO;

import BoardingPass.BoardingPass;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BoardingPassIO {//WHERE THE PARAMETERS GO//THIS WILL MOST LIKELY BE WHERE WE GET ALL OF THE INFORMATION AND PUT THEM INTO FILES
    public static boolean writeBoardingPassToFile(BoardingPass pass, String filename) {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));

            bufferedWriter.write("{");
            writeField(bufferedWriter, "BoardingPassNumber", pass.getBoardingPassNumber(), true);
            writeField(bufferedWriter, "Name", pass.getName(), true);
            writeField(bufferedWriter, "Email", pass.getEmail(), true);
            writeField(bufferedWriter, "PhoneNumber", pass.getPhoneNumber(), true);
            writeField(bufferedWriter, "Gender", pass.getGender().name(), true);
            writeField(bufferedWriter, "Age", Integer.toString(pass.getAge()), true);
            writeField(bufferedWriter, "Date", pass.getDate(), true);
            writeField(bufferedWriter, "Origin", pass.getOrigin(), true);
            writeField(bufferedWriter, "Destination", pass.getDestination(), true);
            writeField(bufferedWriter, "DepartureTime", pass.getDepartureTime(), true);
            writeField(bufferedWriter, "EstimatedTimeArrival", pass.getEstimatedTimeArrival(), true);
            writeField(bufferedWriter, "TicketPrice", Float.toString(pass.getTicketPrice()), false);
            bufferedWriter.write("}\n");

            bufferedWriter.close();
        } catch (IOException except) {
            except.printStackTrace();
            return false;
        }
        return true;  // return true is success, false if fail
    }

    private static void writeField(BufferedWriter bufferedWriter, String fieldName, String fieldValue, boolean newLine) throws IOException {
        bufferedWriter.write(String.format("%s={%s}%s", fieldName, fieldValue, newLine ? "\n" : ""));
    }

    public boolean isDuplicate(String passNum){
        // Import file from location
        // for loop iterate through the pass number values, looking for duplicates
        // if duplicate found, re-run passNumber()
        // otherwise, return passNum to be written to the appropriate entry

        return true; // TODO
    }
}