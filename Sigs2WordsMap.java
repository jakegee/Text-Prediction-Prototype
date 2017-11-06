package predictive;
/*
 * @author Jacob Smith
 * Class that loops through the length of the the input through the signatureToWords function using the command line
 */
public class Sigs2WordsMap {

	public static void main(String[] args) throws Exception {
		MapDictionary storedDictionary = new MapDictionary("words.txt");
			for (int i = 0; i < args.length; i++) {
				System.out.println(storedDictionary.signatureToWords(args[i]));
			}
	}
}
