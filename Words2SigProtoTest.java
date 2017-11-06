package predictive;

import java.io.IOException;
import org.junit.Test;
/*
 * @author Jacob Smith
 * Tests Words2SigProto
 */
public class Words2SigProtoTest {
	
	@Test
	public void test1() throws IOException { // Tests home to return its key signature
        Words2SigProto.main(new String[]{"home"});
	}
	
	@Test
	public void test2() throws IOException { // Tests day to return its key signature
        Words2SigProto.main(new String[]{"day"});
	}

}