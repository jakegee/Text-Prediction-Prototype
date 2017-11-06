package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/*
 * @author Jacob Smith
 * MapDictionary class uses a HashMap now for storing the dictionary data. This should be a better way of 
 * storing data and will be verified with our tests. It uses some of the same principals and ideas used in 
 * ListDictionary and PredictivePrototype and implements the Dictionary interface.
 */

public class MapDictionary implements Dictionary {

	protected HashMap<String, Set<String>> storedDict;  // Creating of the HashMap 

	public MapDictionary(String dictionaryPath) throws IOException {
		this.storedDict = new HashMap<>(); // the HashMap gets populated with the stored dictionary words
		
		BufferedReader reader = null;
		File file = new File("words.txt");
		reader = new BufferedReader(new FileReader(file));	
		String line;
		while ((line = reader.readLine()) !=null) {
			line = line.toLowerCase();
			String signature  = PredictivePrototype.wordToSignature(line);
		

			if (PredictivePrototype.isValidWord(line)) {
				storedDict.put(signature, getpWord(line, signature));
			}
		}
		reader.close();
	}

	/*
	 * This method is used for storing words in a set used by the HashMap.
	 */
	public Set<String> getpWord(String word, String signature) {
		Set<String> pWord = new HashSet<>();
		if (!storedDict.containsKey(signature)) { // Checks to see if it has the signature 
			pWord.add(word); // if so add that word
			storedDict.put(signature, pWord);
		} else { // else the if the word is found then add that word to the already made set
			pWord = storedDict.get(signature);
			pWord.add(word);
			storedDict.put(signature, pWord);
		}
	return pWord; // returns the possible word
	}

	@Override
	public Set<String> signatureToWords(String signature) {
		if (storedDict.containsKey(signature)) { // if the stored dictionary has the signature
			return storedDict.get(signature); // return that signature
		} else {
		return Collections.emptySet(); // else returns the collection
		}
	}
	/*
	 * Main method that tests to make sure the MapDictionary is working
	 */
	public static void main(String[] args) throws IOException {
		try {
			MapDictionary hello = new MapDictionary("words.txt");
			System.out.println(hello.signatureToWords("4663"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
