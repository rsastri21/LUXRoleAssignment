package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
The purpose of this class is to facilitate reading Candidate and Productions information
from a provided CSV file.
 */
public class CSVReader {

    // Store the information from the response CSV into a two-dimensional array.
    // Parameters:
    //      File csv - File to read information from.
    //      List<List<String>> output - Output reference to store information.
    public static String readCandidates(File csv, List<List<String>> output) {
        // Check file validity
        if (!validFile(csv)) {
            return "Invalid file type";
        }

        try {
            FileReader csvFile = new FileReader(csv);
            // Use a buffered reader to read CSV.
            BufferedReader reader = new BufferedReader(csvFile);
            String line = "";

            // Iterate through lines
            while ((line = reader.readLine()) != null) {
                output.add(Arrays.asList(line.split(",")));
            }
            reader.close();

            return "Success";

        } catch (IOException e){
            e.printStackTrace(); // Remove when development is done.
            return "Invalid file";
        }

    }

    // Creates a production from a production definition form.
    // Parameters:
    //      File csv - The definition to read the file from.
    // Returns:
    //      A constructed production object with prefilled roles.
    public static Production readProduction(File csv) {
        // Check file validity
        if (!validFile(csv)) {
            throw new IllegalArgumentException();
        }

        try {
            FileReader csvFile = new FileReader(csv);
            BufferedReader reader = new BufferedReader(csvFile);
            String line = "";

            // Create a list to maintain roles and pre-written assignments
            List<String> roles = new ArrayList<>();
            List<String> assignments = new ArrayList<>();
            // Iterate through lines
            while ((line = reader.readLine()) != null) {
                String[] tempArr = line.split(",");
                roles.add(tempArr[0]);
                assignments.add(tempArr[1]);
            }

            // Create a new production with the role/assignment information.
            String prodName = csv.getName().substring(0, csv.getName().lastIndexOf('.'));
            return new Production(roles, assignments, prodName);

        } catch (IOException e) {
            e.printStackTrace(); // Remove when development is done.
            throw new IllegalArgumentException();
        }
    }

    // Returns whether the file is a valid CSV.
    // Parameters:
    //      File csv - File to determine type.
    // Returns:
    //      Boolean indicating validity.
    private static boolean validFile(File csv) {
        // Check that file is of the correct type
        String fileName = csv.getName();
        int lastPeriod = fileName.lastIndexOf('.');
        // Check equality with '.csv'
        return fileName.substring(lastPeriod).equals(".csv");
    }

    // TODO: Method that outputs csv for a production.

    public static void main(String[] args) throws IOException {
        // Tests
        String filePath = "/Users/rohan/Desktop/Rohan's Stuff/LUXRoleAssignment/test/pastFiles/LUX Role Survey AU22 (Responses) - Form Responses 1.csv";
        File csv = new File(filePath);
        List<List<String>> output = new ArrayList<>();
        System.out.println(readCandidates(csv, output));
        System.out.println(output.get(2).get(1));

        csv = new File("/Users/rohan/Desktop/Rohan's Stuff/434_Textbook.pdf");
        output = new ArrayList<>();
        System.out.println(readCandidates(csv, output));

    }

}
