package predictive;

import java.io.IOException;
import java.util.ArrayList;

public class Sig2WordsList {
/*
 * @author Jacob Smith
 * Loops through the length of the the input through the signatureToWords function using the command line
 */
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < args.length; i++) {
			System.out.println(ListDictionary.signatureToWords(args[i]));
		}
	}
}
