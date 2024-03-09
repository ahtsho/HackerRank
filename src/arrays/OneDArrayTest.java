package arrays;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OneDArrayTest {

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
	final void test1() {
		String input =  "1\n"
				+ "97 35\n"
				+ "0 1 1 0 1 1 0 0 1 0 0 0 0 0 1 0 0 1 1 0 0 0 0 1 1 1 0 0 1 0 1 1 1 0 1 1 1 0 1 0 0 1 1 1 1 0 1 1 1 1 1 1 1 0 0 1 1 0 1 1 0 0 0 0 1 0 1 0 0 0 1 0 1 0 1 1 0 1 0 1 0 0 0 1 0 0 0 1 1 0 0 1 0 1 1 1 1\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		OneDArray.main(new String[] {});
    	String expectedOutput = "NO\n";
    
    
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());

    		 

	}
	//@Test
	final void test() {
		String input =  "50\n"
				+ "66 78\n"
				+ "0 1 1 0 1 0 1 1 0 1 0 1 1 0 0 0 1 1 0 0 1 0 1 1 0 0 1 1 0 1 0 0 1 1 0 0 0 1 1 0 0 0 1 1 0 0 1 1 1 1 1 0 0 1 0 0 1 1 1 0 0 1 0 1 0 0\n"
				+ "61 65\n"
				+ "0 1 1 1 1 1 0 0 1 0 0 1 0 1 0 0 1 1 0 1 1 1 0 1 0 1 1 1 0 1 1 0 0 1 1 1 0 0 1 0 0 1 1 0 1 1 1 0 1 1 0 0 1 0 1 1 0 0 0 0 1\n"
				+ "21 41\n"
				+ "0 1 1 0 0 1 0 1 1 0 1 0 1 0 0 0 0 1 1 0 1\n"
				+ "21 24\n"
				+ "0 0 1 1 0 0 1 1 0 1 0 1 1 0 0 1 1 0 0 0 0\n"
				+ "26 21\n"
				+ "0 0 1 1 1 0 1 0 1 0 0 0 1 0 0 0 1 0 0 1 1 1 1 0 1 1\n"
				+ "68 6\n"
				+ "0 1 0 0 0 1 1 1 0 1 0 1 0 1 1 1 0 0 1 1 1 0 1 1 1 0 0 1 1 1 1 0 1 0 0 1 1 1 0 1 1 0 0 1 1 0 0 0 0 0 1 1 0 0 0 1 0 1 1 0 0 0 0 1 0 1 0 1\n"
				+ "34 9\n"
				+ "0 1 1 1 1 1 0 1 1 0 1 1 1 1 1 1 1 1 0 0 0 0 1 0 0 0 1 1 1 0 0 1 1 1\n"
				+ "66 44\n"
				+ "0 0 1 0 0 1 0 1 1 1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 1 0 0 1 1 0 1 0 0 0 1 0 0 1 0 1 0 1 1 0 1 0 1 1 0 1 1 1 0 1 0 1 1 0 0 0 0 0 1 1 0 0\n"
				+ "63 25\n"
				+ "0 1 1 1 1 0 1 1 1 1 1 0 1 0 0 1 0 1 1 0 0 1 0 0 0 0 1 1 1 1 0 1 0 0 1 1 0 0 1 0 1 0 0 0 0 0 1 1 1 0 1 1 0 1 0 0 0 1 1 1 1 1 0\n"
				+ "22 94\n"
				+ "0 1 1 0 1 0 0 0 0 0 1 0 1 0 1 0 1 0 0 1 0 0\n"
				+ "21 43\n"
				+ "0 1 0 1 0 1 1 0 1 1 1 1 0 1 1 1 1 1 0 1 0\n"
				+ "27 82\n"
				+ "0 1 1 1 1 0 1 1 1 1 0 1 0 1 1 0 1 0 1 0 1 1 1 0 0 0 1\n"
				+ "29 78\n"
				+ "0 0 1 0 1 0 0 0 1 1 1 0 1 1 0 1 0 1 1 1 1 0 1 0 0 0 0 0 0\n"
				+ "33 60\n"
				+ "0 0 1 0 0 0 0 0 0 1 0 1 0 1 1 0 0 1 1 0 1 0 0 0 0 0 1 0 1 1 1 0 1\n"
				+ "27 97\n"
				+ "0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 1 0 1 1 0 1 1 1 0 1 0 0\n"
				+ "97 35\n"
				+ "0 1 1 0 1 1 0 0 1 0 0 0 0 0 1 0 0 1 1 0 0 0 0 1 1 1 0 0 1 0 1 1 1 0 1 1 1 0 1 0 0 1 1 1 1 0 1 1 1 1 1 1 1 0 0 1 1 0 1 1 0 0 0 0 1 0 1 0 0 0 1 0 1 0 1 1 0 1 0 1 0 0 0 1 0 0 0 1 1 0 0 1 0 1 1 1 1\n"
				+ "51 85\n"
				+ "0 1 0 1 1 0 1 1 1 1 0 1 0 0 1 0 1 1 0 0 1 1 0 1 1 0 0 0 0 1 1 0 0 1 1 0 1 0 1 0 1 1 0 1 1 1 1 0 1 1 0\n"
				+ "25 76\n"
				+ "0 0 1 0 1 0 0 1 1 1 1 0 1 0 0 0 0 1 1 1 0 1 0 1 0\n"
				+ "17 16\n"
				+ "0 1 0 0 1 1 0 1 1 1 1 0 0 0 1 1 0\n"
				+ "63 38\n"
				+ "0 0 1 1 1 0 0 1 1 0 0 1 1 0 1 0 0 0 1 0 1 1 0 0 1 0 1 0 0 1 1 1 0 0 1 1 0 1 1 1 0 1 0 1 1 1 1 1 0 1 0 1 0 0 0 1 0 1 1 0 0 0 0\n"
				+ "24 17\n"
				+ "0 1 0 0 0 1 1 0 0 0 0 0 1 1 1 1 0 1 1 0 1 1 1 0\n"
				+ "87 58\n"
				+ "0 0 0 1 0 1 0 1 1 0 0 0 0 0 0 0 0 0 1 0 0 1 0 1 0 1 1 1 0 1 1 1 1 1 1 0 0 1 1 1 1 1 1 1 0 0 1 0 0 1 0 0 0 1 0 0 0 1 1 0 0 0 0 1 1 1 1 0 0 1 1 1 0 1 1 0 1 0 1 1 1 1 0 1 0 0 1\n"
				+ "89 72\n"
				+ "0 0 1 1 0 1 0 0 0 0 0 0 1 1 1 1 0 0 0 1 1 1 1 0 0 1 0 1 1 1 1 0 0 0 1 0 1 1 0 1 1 0 1 0 0 1 0 0 1 0 0 0 1 1 1 1 0 1 0 1 0 0 1 0 0 0 1 0 1 1 1 1 0 1 1 0 0 1 0 1 1 0 0 0 1 1 0 1 0\n"
				+ "85 51\n"
				+ "0 0 0 1 1 1 1 0 1 1 1 0 0 1 1 1 1 1 1 0 1 0 0 1 1 0 0 1 1 0 1 0 0 0 1 1 1 1 1 0 0 1 0 0 0 0 1 0 1 0 0 0 1 0 1 0 0 1 1 0 1 0 0 0 0 1 1 1 0 1 1 0 0 0 0 0 0 0 0 1 0 0 0 1 1\n"
				+ "30 8\n"
				+ "0 1 1 0 1 0 1 1 0 1 1 0 1 1 1 0 0 1 0 0 1 0 0 0 0 1 0 0 0 1\n"
				+ "15 41\n"
				+ "0 1 0 0 0 1 1 0 1 1 1 1 0 0 0\n"
				+ "87 1\n"
				+ "0 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 0 1 1 0 0 1 0 0 0 1 1 0 0 0 0 0 1 1 1 0 1 1 1 0 1 1 0 0 0 1 1 0 0 1 0 1 0 1 1 0 0 0 0 0 0 0 1 0 0 0 0 1 1 0 1 1 1 1 1 1 0 1 1 1 0 1 0 0 0 1 0\n"
				+ "2 54\n"
				+ "0 0\n"
				+ "82 19\n"
				+ "0 0 0 0 0 1 0 1 0 0 1 1 1 0 1 0 1 0 1 0 0 1 0 0 1 1 0 0 0 0 0 0 0 0 0 1 1 1 0 0 1 1 1 1 0 0 1 1 0 1 1 0 0 1 0 1 0 0 0 0 0 0 1 1 0 1 0 0 0 0 0 0 0 1 1 0 0 0 1 0 1 0\n"
				+ "84 56\n"
				+ "0 1 1 1 1 0 1 1 0 1 0 1 1 0 1 1 0 0 1 0 0 1 1 0 1 0 1 1 1 1 0 1 0 0 0 1 0 1 0 0 0 1 0 1 1 1 1 1 1 0 0 1 1 1 1 0 1 0 0 1 1 0 0 1 0 0 0 0 1 1 1 1 0 1 0 1 0 1 0 0 0 0 1 1\n"
				+ "20 38\n"
				+ "0 0 1 1 0 0 1 0 0 0 1 0 1 1 1 0 0 0 0 1\n"
				+ "20 18\n"
				+ "0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 1\n"
				+ "36 26\n"
				+ "0 0 1 0 0 1 1 0 1 0 1 1 0 1 1 1 1 0 1 1 1 1 0 1 1 0 0 1 1 1 1 0 0 0 0 0\n"
				+ "68 50\n"
				+ "0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 0 1 1 1 0 0 1 0 0 0 1 0 1 0 0 1 0 0 1 0 0 0 0 1 0 0 1 1 0 0 1 0 1 0 0 0 1 1 0 1 1 1 1 1 1 0 0 0 0\n"
				+ "15 51\n"
				+ "0 0 1 0 0 1 0 1 0 0 0 1 1 1 1\n"
				+ "4 50\n"
				+ "0 0 0 0\n"
				+ "30 47\n"
				+ "0 1 1 1 1 1 1 1 1 0 1 0 1 1 0 0 0 1 0 0 1 1 1 1 0 0 0 1 1 0\n"
				+ "88 18\n"
				+ "0 0 0 0 1 0 1 0 1 1 1 1 0 0 1 0 0 1 0 1 0 1 0 1 1 1 0 0 0 0 1 1 0 0 1 1 0 0 1 1 1 0 1 1 1 0 1 1 1 1 0 0 0 1 1 1 0 1 0 0 0 1 1 0 1 0 0 1 0 1 1 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 1 0\n"
				+ "16 86\n"
				+ "0 0 1 1 1 1 0 1 1 0 1 1 1 0 1 1\n"
				+ "33 83\n"
				+ "0 1 1 0 1 1 1 1 1 1 1 0 1 0 0 1 1 1 0 0 1 1 0 1 0 1 0 0 0 1 0 0 1\n"
				+ "40 5\n"
				+ "0 0 0 0 0 1 1 1 0 1 1 0 0 0 1 1 0 0 0 0 0 1 1 0 1 1 0 0 1 1 1 0 1 0 0 1 1 1 0 1\n"
				+ "53 42\n"
				+ "0 1 1 1 0 0 0 1 0 0 1 1 0 1 1 1 1 1 1 0 0 1 0 0 1 1 0 0 0 1 1 1 1 0 1 1 0 1 0 0 1 1 0 1 1 1 1 0 0 0 1 0 1\n"
				+ "18 100\n"
				+ "0 0 0 1 0 0 0 1 0 1 1 1 1 1 0 1 0 1\n"
				+ "25 99\n"
				+ "0 1 0 1 0 0 1 0 1 1 1 0 0 1 1 1 1 1 0 1 1 1 0 0 0\n"
				+ "26 45\n"
				+ "0 0 0 0 1 0 1 1 1 1 1 0 1 1 1 0 1 0 1 0 1 0 0 1 1 1\n"
				+ "66 3\n"
				+ "0 0 1 0 0 1 0 0 0 0 1 1 1 0 1 1 1 0 0 1 1 0 0 0 0 1 0 1 0 1 0 0 1 0 0 0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 1 0 1 0 0 1 1 0 1 1 1 1 0 1 1 0\n"
				+ "10 8\n"
				+ "0 1 1 1 1 1 0 1 0 1\n"
				+ "9 7\n"
				+ "0 1 0 1 1 0 1 1 1\n"
				+ "28 8\n"
				+ "0 0 0 1 0 0 0 1 0 1 0 1 0 1 1 0 0 0 0 1 1 0 0 0 1 0 0 1\n"
				+ "26 96\n"
				+ "0 1 1 0 1 0 0 1 0 1 0 1 0 1 1 1 0 1 1 0 1 0 0 1 1 0";
				
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	OneDArray.main(new String[] {});
    	String expectedOutput = 
    			"YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "NO\n"
    			+ "YES\n"
    			+ "YES";
    	
    	String[] expectedOutputLine = expectedOutput.split("\n");
    	String[] outputStreamCaptorLine = outputStreamCaptor.toString().split("\n");
    	
    	for (int i = 0; i < expectedOutputLine.length; i++) {
    	    Assert.assertEquals("Mismatch at line "+input.split("\n")[(i+1)*2] , expectedOutputLine[i], outputStreamCaptorLine[i]);

    		 
    	}

	}

}
