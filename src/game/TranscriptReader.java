package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/* NEW CLASS */
// used to read the transcript of the game
public class TranscriptReader {
	
	// method returns a map containing the number of lines, words, and numbers in the game's transcript
	public Map<String, Integer> getCounts() throws FileNotFoundException{
		// first we try to open the file where the transcript is
		// because it could throw an exception we declare that at the top of the method
		File input = new File("txt/lines.txt");
		// then we create a scanner with the file
		Scanner reader = new Scanner(input);
		// variables to hold the counts
		int numbers = 0;
		int words = 0;
		int lines = 0;
		// start looping through the lines
		while(reader.hasNextLine()) {
			// increase the line count every time we start at a new line
			lines++;
			
			// now loop through each word in the line
			// the split method will divide the string into an array of strings divided at a given expression
			// in this case we need to split it at every space to find the next "word"
			for(String word : reader.nextLine().split(" ")) {
				// try to convert the word to an int to see if its a number
				try {
					Integer.parseInt(word);
					//if it is a number, the previous line will not throw an exception and we now now it is a number
					// so we increase the number of numbers by 1
					numbers++;
				}
				// if the conversion of the word to a number did not work, we get a number format exception
				catch(NumberFormatException e) {
					// because the conversion failed, we know the word is actually a word
					// so increase the number of words
					words++;
				}
			}
		
		}
		
		// create a new map to throw all the counts inside to return
		Map<String, Integer> counts = new HashMap<>();
		// put the three counts inside the map
		counts.put("numbers", numbers);
		counts.put("words", words);
		counts.put("lines", lines);
	
		// close out the reader Scanner
		reader.close();
		
		// return the map of counts
		return counts;
		
	}

	
	
}
