package predictive;

import java.util.Set;
/*
 * @author Jacob Smith
 * Interface to be used in the ListDictionary, MapDictionary, and TreeDictionary classes
 */
public interface Dictionary {
	public Set<String> signatureToWords(String signature);
}
