package reg.exp;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepeatingWordsTest {

	private final InputStream sysInBackup = System.in;
	private final PrintStream sysOutBackup = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	@AfterEach
	void tearDown() throws Exception {
		System.setIn(sysInBackup);
		System.setOut(sysOutBackup);
	}

	@Test
	final void test() {
		String input =  "1\n"
				+ "Goodbye bye bye world world world\n";
				/*+ "Sam went went to to to his business\n"
				+ "Reya is is the the best player in eye eye game\n"
				+ "in inthe\n"
				+ "Hello hello Ab aB";*/
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	RepeatingWords.main(new String[] {});
    	String expectedOutput = "Goodbye bye world\n";
    			/*
    			+ "Sam went to his business\n"
    			+ "Reya is the best player in eye game\n"
    			+ "in inthe\n"
    			+ "Hello Ab";*/
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());

	}

}
