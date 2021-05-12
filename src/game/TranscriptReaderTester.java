package game;

import java.io.FileNotFoundException;
import java.util.Map;

// tester for the transcript reader
public class TranscriptReaderTester {
	
	public static void main(String[] args) throws FileNotFoundException {
		// we create a transcript reader, get the counts, and print them out one by one
		TranscriptReader r = new TranscriptReader();
		Map<String, Integer> counts = r.getCounts();
		
		System.out.println("Lines in file: " + counts.get("lines"));
		System.out.println("Numbers in file: " + counts.get("numbers"));
		System.out.println("Words in file: " + counts.get("words"));
	}

}
