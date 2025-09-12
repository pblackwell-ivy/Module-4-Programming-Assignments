package Exercise21_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Read a text file and count vowels, upper or lower, and consonants
 * Display the contents of the file and the number of vowels and consonants
 * Include error checking if the file isn't found
 * Use a set to store the vowels A, E, I, O, and U.  this uses a HashSet.
 * Use StringBuilder to store the contents of the file
 */
public class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        // prompt for file name
        System.out.print("Enter a filename: ");
        String filename = console.nextLine();

        // Store vowels once (uppercase) and compare using Character.toUpperCase(c)
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

        // Declare and initialize data elements
        int vowelCount = 0;
        int consonantCount = 0;
        StringBuilder fileContents = new StringBuilder();

        // Create a file reference and a Scanner to prepare for reading the contents
        File file = new File(filename);

        // Check if file exists.  If not, provide error message
        if (!file.exists()) {
            System.out.println("Could not find file: " + file.getAbsolutePath());  // added path to help debug
            return;
        }

        // use "try (declare and create resource) { process resource }" construct
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();  //
                fileContents.append(line).append('\n');

                // Loop through each character in the line
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (Character.isLetter(c)) {  // ignore non-letters
                        char upperChar = Character.toUpperCase(c);
                        if (vowels.contains(upperChar)) {
                            vowelCount++;
                        } else {
                            consonantCount++;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
            return;
        }

        System.out.println("File contents: " + fileContents.toString().trim());
        System.out.println("the number of vowels is " + vowelCount + " and consonants is " + consonantCount);
    }
}


