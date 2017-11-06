
package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PredictivePrototype {
/*
 * @author Jacob Smith
 * Class PredictivePrototype takes an input, similar to t9 on an old cell phone, through the command line
 * to return the first matching word that comes out in a dictionary. It also returns different words in the 
 * dictionary that match the keys pressed. In addition, we verify that the word is valid and does exist
 * in the dictionary.
 */
	
	public static String wordToSignature(String Word) { // This method returns the numeric keys for 
		// a word that is input
		StringBuffer s = new StringBuffer(); // we use a StringBuffer because we want object to be mutable ie changeable
		
		for (char c: Word.toCharArray()) { // Using a for each loops to iterate through the characters 
			// of the alphabet then, appending them to a string
			
            if(c == 'a' || c == 'b' || c == 'c') { // if statements correspond to the keys pressed like on a cell phone
                s.append(2);
            }
            else if(c == 'd' || c == 'e' || c == 'f') {
                s.append(3);
            }
            else if(c == 'g' || c == 'h' || c == 'i') {
                s.append(4);
            }
            else if(c == 'j' || c == 'k' || c == 'l') {
                s.append(5);
            }
            else if(c == 'm' || c == 'n' || c == 'o') {     
            	s.append(6);
            }
            else if(c == 'p' || c == 'q' || c == 'r' || c == 's') {
                s.append(7);
            }
            else if(c == 't' || c == 'u' || c == 'v') {
                s.append(8);
            }
            else if(c == 'w' || c == 'x' || c == 'y' || c == 'z') {
                s.append(9);
            }
		}
		return s.toString();
	}
/*
 * signatureToWords takes the the number keys and returns possible dictionary words for the key inputs 
 */
		public static Set<String> signatureToWords(String signature) throws IOException {
			Set<String> sigMatch = new HashSet<String>();
			File file = new File("words.txt"); // The words dictionary file is opened in order to read every entry
			// I had to use my own words dictionary that I placed in my javaworkspace folder because I had issues
			// reading the words file found in my /usr/share/dict/words path
			BufferedReader reader = null;
			
				reader = new BufferedReader(new FileReader(file));
				
				String line;
				while ((line = reader.readLine()) != null) { // While the line read is not null
					if (line.length()==signature.length() && isValidWord(line)) { // and the length of the key is the same
						// as the length of the dictionary word, as well as a word in the dictionary
						if (wordToSignature(line).equals(signature)) { 
							line = line.toLowerCase(); // makes the word into a lowercase word if necessary
							if (!(sigMatch.contains(line)));
								sigMatch.add(line); // adds any dictionary matches to the line
						}
					}
				}
				reader.close(); // closes reader once done with the file
				
				return sigMatch; // returns the matches to the key input
		}
/*
 * This boolean simply verifies if the world is valid and the characters used are all alphabetical		  
 */
		static boolean isValidWord(String word) {
			word = word.toLowerCase();
			for (int i = 0; i < word.length(); i++) {
				int character = (int)word.charAt(i);
				if (!(character >= 97 && character <= 122)) {
					return false;
				}
            }
			return true; 
		}
	}


