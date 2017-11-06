package predictive;
/*
 * @author Jacob Smith
 * Test for PredictivePrototype
 */
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PredictivePrototypeTest {
	
	@Test
	public void test1() throws IOException { // Tests that key signature 4663 returns all the words
												 // that could be possible matches found in my words.txt dictionary

		Set<String> expected = new HashSet<String>();

		expected.add("hood");
		expected.add("good");
		expected.add("inne");
		expected.add("hond");
		expected.add("hone");
		expected.add("hoof");
		expected.add("gond");
		expected.add("gone");
		expected.add("home");
		expected.add("goof");
		expected.add("gome");

		Set<String> result = PredictivePrototype.signatureToWords("4663");

		assertEquals(expected, result);
	}
	
	@Test
	public void test2() throws IOException { // Tests that key signature 329 returns all the words
												 // that could be possible matches found in my words.txt dictionary

		Set<String> expected = new HashSet<String>();

		expected.add("daw");
		expected.add("fax");
		expected.add("day");
		expected.add("fcy");
		expected.add("fay");

		Set<String> result = PredictivePrototype.signatureToWords("329");

		assertEquals(expected, result);
	}
}