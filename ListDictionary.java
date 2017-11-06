package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * @author Jacob Smith
 * This class uses the words dictionary and stores the their key signatures in an ArrayList
 */
public class ListDictionary implements Dictionary {
		
	private ArrayList<WordSig> t9dict;
	
	public ListDictionary(String filePath) throws IOException { 
			// Constructor to create a ListDictionary object that's used to store the words and key signatures
			// in an array. Similarly runs the way PredictivePrototype class runs, the words must be valid for them to be
			// added to the list, then sorted in the Collection method.
		this.t9dict = new ArrayList<>();	
		
		BufferedReader reader = null;
		File file = new File("words.txt");			
		reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) !=null) {				
			line = line.toLowerCase();
			if (isValidWord(line)) {
				WordSig ws = new WordSig(line, wordToSignature(line));
				t9dict.add(ws);
					}
				}
			reader.close();
			Collections.sort(t9dict); // Sorts in ascending order
		}
		
		public ArrayList<WordSig> getT9dict() {
			return t9dict; // returns the current dictionary word
		}
		
		public void printT9dict() {
			for (WordSig ws : t9dict) {
				System.out.println(ws); // prints the word and then the key signature
			}
		}
		/*
		 * This method uses binary search through the dictionary for possible matches with the key signature.
		 * Using an index helps in storing a match so that it may be checked against the key signature, any word with
		 * a matching signature gets stored to the list.
		 */
		public Set<String> signatureToWords(String signature) {
			Set<String> possible = new HashSet<String>(); 
			WordSig searchSig = new WordSig("", signature);
			
			int index = Collections.binarySearch(this.t9dict, searchSig);
			
			if (index >= 0) { // The size must be greater than or equal to 0 in order for a match to be possible
			possible.add(this.t9dict.get(index).getWord());
			
			int temp = index; // Using the index to hold the temp key signatures
			while (this.t9dict.get(temp).getSignature().equals(signature)) {
				if (!(possible.contains(this.t9dict.get(temp).getWord()))) {
					possible.add(this.t9dict.get(temp).getWord());
				}
		    	temp--;
		    	if(temp == -1)
		    		break;
		    }

			temp = index;
		    while(this.t9dict.get(temp).getSignature().equals(signature)){
		    	if(!(possible.contains(this.t9dict.get(temp).getWord()))){
		    		possible.add(this.t9dict.get(temp).getWord());
		    	}
		    	temp++;
		    	if(temp == this.t9dict.size())
		    		break;
		    }
	    }
		return possible; // returns any possible matches
		}
		/*
		 * The keypad simply used from PredictivePrototype
		 */
		public static String wordToSignature(String Word) {
			StringBuffer s = new StringBuffer();
			
			for (char c: Word.toCharArray()) {
				
	            if(c == 'a' || c == 'b' || c == 'c') { 
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
		 * Simply using the same isValidWord from PredictivePrototype
		 */
		private static boolean isValidWord(String word) {
			word = word.toLowerCase();
			for (int i = 0; i < word.length(); i++) {
				int character = (int)word.charAt(i);
				if (!(character >= 97 && character <= 122)) {
					return false;
				}
            }
			return true;
		}
		/*
		 * Main method test used to test the methods above
		 */
//		public static void main(String[] args){
//			try{
//			ListDictionary hello= new ListDictionary("words.txt");
//			System.out.println(hello.signatureToWords("4663"));
			
//			}
//			catch(IOException e){
//				System.out.println("IOE caught");
//			}
//		}

}
