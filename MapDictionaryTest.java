package predictive;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jacob Smith
 * Tests for MapDictionary
 */

public class MapDictionaryTest {
	
	private MapDictionary mapDict;
	
	@Before
	public void setUp() throws IOException { // Tests that key signature 4663 returns all the words
		 										 // that could be possible matches found in my words.txt dictionary
												 // except this time using a private type for MapDictionary
		mapDict = new MapDictionary("words.txt");
	}
	@Test
	public void test1() throws IOException {

		Set<String> expected = new TreeSet<String>();

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

		Set<String> result = mapDict.signatureToWords("4663");

		assertEquals(expected, result);
	}
	
	@Test
	public void test2() throws IOException { // Tests that key signature 329 returns all the words
												 // that could be possible matches found in my words.txt dictionary

		Set<String> expected = new TreeSet<String>();

		expected.add("daw");
		expected.add("fax");
		expected.add("day");
		expected.add("fcy");
		expected.add("fay");

		Set<String> result = mapDict.signatureToWords("329");

		assertEquals(expected, result);
	}

}