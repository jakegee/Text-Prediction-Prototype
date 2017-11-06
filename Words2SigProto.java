package predictive;

public class Words2SigProto {
/*
 * @author Jacob Smith
 * Loops through the length of the the input through the wordToSingatures function using the command line
 */
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
		}

	}

}
