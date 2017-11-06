package predictive;
/*
 * @author Jacob Smith
 */
public class WordSig implements Comparable<WordSig> { // We create the WordSig object to hold the word and key strings

	private String word;
	private String signature;
	
	public WordSig(String word, String signature) {
		this.word = word;
		this.signature = signature;
	}
	public String getWord() { // getWord is used to return a string from WordSig
		return word;
	}
	
	public String getSignature() { // getSignature is used to return a string as well
		return signature;
	}
	
	@Override
	public String toString() { // used to display the word and the key signature
		return word + " : " + signature;
	}
	
	public int compareTo(WordSig ws) { // This method compares WordSig to the ordered signature
		if (this.getSignature().compareTo(ws.getSignature()) > 0) {
			return 1; // return -1 when it's less than
		} else if (this.getSignature().compareTo(ws.getSignature()) < 0) {
			return -1; // return 1 when it's greater than
		} else { 
			return 0; // else we return 0 for when they are the same
		}
	}
}
