import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args){
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        Map<String, Integer> wordCounts = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String word;
            while ((word = reader.readLine()) != null) {
                word = word.toLowerCase();
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
            System.out.println("Word counts sucessfully written to " + outputFile + " file!");
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }
}
