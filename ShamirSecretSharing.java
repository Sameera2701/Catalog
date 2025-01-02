import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.json.*;

public class SecretSharing {
    public static void ShamirSecretSharing(String[] args) throws Exception {
        // Specify the input file path
        String inputFilePath = "input.json";
        
        // Read the content of the input JSON file
        String inputJson = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        
        // Parse the input JSON using org.json library
        JSONObject jsonObject = new JSONObject(inputJson);
        
        // Extract the values for n (number of roots) and k (minimum roots needed)
        JSONObject keys = jsonObject.getJSONObject("keys");
        int n = keys.getInt("n");
        int k = keys.getInt("k");
        
        // Lists to store the x and y values for the polynomial points
        List<Integer> xCoordinates = new ArrayList<>();
        List<Integer> yCoordinates = new ArrayList<>();
        
        // Iterate through the JSON object to extract roots and their respective values
        for (String key : jsonObject.keySet()) {
            if (!key.equals("keys")) {
                JSONObject rootData = jsonObject.getJSONObject(key);
                int base = Integer.parseInt(rootData.getString("base"));
                String encodedValue = rootData.getString("value");
                int x = Integer.parseInt(key);
                int y = Integer.parseInt(encodedValue, base);  // Decode the value based on the base
                xCoordinates.add(x);
                yCoordinates.add(y);
            }
        }

        // Use Lagrange interpolation to find the constant term of the polynomial
        double constantTerm = calculateConstant(xCoordinates, yCoordinates, k);
        
        // Display the calculated constant term
        System.out.println("Calculated constant term (c): " + constantTerm);
        
        // Save the result to an output file
        try (PrintWriter outputWriter = new PrintWriter("output.txt")) {
            outputWriter.println("Calculated constant term (c): " + constantTerm);
        }
    }

    // Method to compute the constant term (c) using Lagrange interpolation
    private static double calculateConstant(List<Integer> xCoordinates, List<Integer> yCoordinates, int k) {
        double constant = 0.0;
        // Iterate over each point and calculate the corresponding term for Lagrange interpolation
        for (int i = 0; i < k; i++) {
            double term = yCoordinates.get(i);
            for (int j = 0; j < k; j++) {
                if (i != j) {
                    term *= (0.0 - xCoordinates.get(j)) / (xCoordinates.get(i) - xCoordinates.get(j));
                }
            }
            constant += term;
        }
        return constant;
    }
}
