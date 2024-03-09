package hr.datatypes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*;


class DataTypesTest {

	private final InputStream sysInBackup = System.in;
	private final PrintStream sysOutBackup = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}

    @AfterEach
    public void restoreStreams() {
        System.setIn(sysInBackup);
        System.setOut(sysOutBackup);
    }
    
    @Test
    public void testCase0() {
    	String input = 
    			"5\n"
    			+ "-150\n"
    			+ "150000\n"
    			+ "1500000000\n"
    			+ "213333333333333333333333333333333333\n"
    			+ "-100000000000000";
    	
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput = 
    			"-150 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "150000 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "1500000000 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "213333333333333333333333333333333333 can't be fitted anywhere.\n"
    			+ "-100000000000000 can be fitted in:\n"
    			+ "* long\n";
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    
    @Test
    public void testCase1() {
    	String input = 
    			"17\n"
    			+ "9223372036854775808\n"
    			+ "9223372036854775807\n"
    			+ "-9223372036854775808\n"
    			+ "-9223372036854775807\n"
    			+ "4294967296\n"
    			+ "4294967295\n"
    			+ "-4294967296\n"
    			+ "-4294967295\n"
    			+ "65536\n"
    			+ "65535\n"
    			+ "-65536\n"
    			+ "-65535\n"
    			+ "256\n"
    			+ "255\n"
    			+ "-256\n"
    			+ "-255\n"
    			+ "12222222222222222222222222222222222222222221";
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput = 
    			"9223372036854775808 can't be fitted anywhere.\n"
    			+ "9223372036854775807 can be fitted in:\n"
    			+ "* long\n"
    			+ "-9223372036854775808 can be fitted in:\n"
    			+ "* long\n"
    			+ "-9223372036854775807 can be fitted in:\n"
    			+ "* long\n"
    			+ "4294967296 can be fitted in:\n"
    			+ "* long\n"
    			+ "4294967295 can be fitted in:\n"
    			+ "* long\n"
    			+ "-4294967296 can be fitted in:\n"
    			+ "* long\n"
    			+ "-4294967295 can be fitted in:\n"
    			+ "* long\n"
    			+ "65536 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "65535 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-65536 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-65535 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "256 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "255 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-256 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-255 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "12222222222222222222222222222222222222222221 can't be fitted anywhere.\n";
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testCaseByte() {
    	String input = 
    			"4\n"
    			+ "-129 \n"
    			+ "-128 \n"
    			+ "127 \n"
    			+ "128";
    				
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput =""
    			+"-129 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+"-128 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "127 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "128 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n";
    			
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testCaseShort() {
    	String input = 
    			"4\n"
    			+ "-32769 \n"
    			+ "-32768 \n"
    			+ "32767 \n"
    			+ "32768";
    				
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput =""
    			+"-32769 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+"-32768 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "32767 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "32768 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n";
    			
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
    
    @Test
    public void testCaseInt() {
    	String input = 
    			"4\n"
    			+ "-2147483649 \n"
    			+ "-2147483648 \n"
    			+ "2147483647 \n"
    			+ "2147483648";
    				
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput =""
    			+"-2147483649 can be fitted in:\n"
    			+ "* long\n"
    			+"-2147483648 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "2147483647 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "2147483648 can be fitted in:\n"
    			+ "* long\n";
    			
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testCaseLong() {
    	String input = 
    			"4\n"
    			+ "-9223372036854775809 \n"
    			+ "-9223372036854775808 \n"
    			+ "9223372036854775807 \n"
    			+ "9223372036854775808";
    				
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput =""
    			+"-9223372036854775809 can't be fitted anywhere.\n"
    			+"-9223372036854775808 can be fitted in:\n"
    			+ "* long\n"
    			+ "9223372036854775807 can be fitted in:\n"
    			+ "* long\n"
    			+ "9223372036854775808 can't be fitted anywhere.\n";
    			
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    //@Test
    public void testCase2() {
    	String input = 
    			"81\n"
    			+ "0 \n"
    			+ "1 \n"
    			+ "-1 \n"
    			+ "18446744073709551616 \n"
    			+ "-18446744073709551616 \n"
    			+ "18446744073709551615 \n"
    			+ "-18446744073709551616 \n"
    			+ "32768 \n"
    			+ "-32768 \n"
    			+ "32767 \n"
    			+ "-32767 \n"
    			+ "2147483648 \n"
    			+ "2147483647 \n"
    			+ "-2147483648 \n"
    			+ "-2147483647 \n"
    			+ "128 \n"
    			+ "127 \n"
    			+ "-128 \n"
    			+ "-127 \n"
    			+ "123123123333333333333333333333333313123123 \n"
    			+ "234444444444444444444444444444444444444 \n"
    			+ "-1222222 \n"
    			+ "11110000000 \n"
    			+ "123123 \n"
    			+ "123 \n"
    			+ "1 \n"
    			+ "0 \n"
    			+ "4343434324 \n"
    			+ "-123123 \n"
    			+ "-123123123 \n"
    			+ "-435345 \n"
    			+ "-56545654654645 \n"
    			+ "123123123123 \n"
    			+ "56546 \n"
    			+ "2341234254 \n"
    			+ "6756856856745634563 \n"
    			+ "-123123123123 \n"
    			+ "-2342342 \n"
    			+ "2345235235 \n"
    			+ "18446744073709551606 \n"
    			+ "-18446744073709551606 \n"
    			+ "23423434444444444444 \n"
    			+ "234234234234234234234 \n"
    			+ "453456345234234 \n"
    			+ "4235346305683 \n"
    			+ "-12312312312312 \n"
    			+ "4353453 \n"
    			+ "42342342342342353456 \n"
    			+ "-3534634563456456456456456456456456456456456456456 \n"
    			+ "-12343242342342342342342342343 \n"
    			+ "-123 \n"
    			+ "-345345345 \n"
    			+ "-345345 \n"
    			+ "123124342355 \n"
    			+ "234324234234234 \n"
    			+ "23452453453453453 \n"
    			+ "-2345234 \n"
    			+ "-131231 \n"
    			+ "-2342342 \n"
    			+ "-456456 \n"
    			+ "17 \n"
    			+ "9223372036854775808 \n"
    			+ "9223372036854775807 \n"
    			+ "-9223372036854775808 \n"
    			+ "-9223372036854775807 \n"
    			+ "4294967296 \n"
    			+ "4294967295 \n"
    			+ "-4294967296 \n"
    			+ "-4294967295 \n"
    			+ "65536 \n"
    			+ "65535 \n"
    			+ "-65536 \n"
    			+ "-65535 \n"
    			+ "256 \n"
    			+ "255 \n"
    			+ "-256 \n"
    			+ "-255 \n"
    			+ "12222222222222222222222222222222222222222221 \n"
    			+ "23423424234234 \n"
    			+ "-23123123123123123 \n"
    			+ "-1010000 ";
    	
    	System.setIn(new ByteArrayInputStream(input.getBytes()));
    	DataTypes.main(new String[] {});
    	
    	String expectedOutput = 
    			"0 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "1 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-1 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "18446744073709551616 can't be fitted anywhere.\n"
    			+ "-18446744073709551616 can't be fitted anywhere.\n"
    			+ "18446744073709551615 can't be fitted anywhere.\n"
    			+ "-18446744073709551616 can't be fitted anywhere.\n"
    			+ "32768 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-32768 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "32767 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-32767 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "2147483648 can be fitted in:\n"
    			+ "* long\n"
    			+ "2147483647 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-2147483648 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-2147483647 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "128 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "127 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-128 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-127 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "123123123333333333333333333333333313123123 can't be fitted anywhere.\n"
    			+ "234444444444444444444444444444444444444 can't be fitted anywhere.\n"
    			+ "-1222222 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "11110000000 can be fitted in:\n"
    			+ "* long\n"
    			+ "123123 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "123 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "1 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "0 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "4343434324 can be fitted in:\n"
    			+ "* long\n"
    			+ "-123123 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-123123123 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-435345 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-56545654654645 can be fitted in:\n"
    			+ "* long\n"
    			+ "123123123123 can be fitted in:\n"
    			+ "* long\n"
    			+ "56546 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "2341234254 can be fitted in:\n"
    			+ "* long\n"
    			+ "6756856856745634563 can be fitted in:\n"
    			+ "* long\n"
    			+ "-123123123123 can be fitted in:\n"
    			+ "* long\n"
    			+ "-2342342 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "2345235235 can be fitted in:\n"
    			+ "* long\n"
    			+ "18446744073709551606 can't be fitted anywhere.\n"
    			+ "-18446744073709551606 can't be fitted anywhere.\n"
    			+ "23423434444444444444 can't be fitted anywhere.\n"
    			+ "234234234234234234234 can't be fitted anywhere.\n"
    			+ "453456345234234 can be fitted in:\n"
    			+ "* long\n"
    			+ "4235346305683 can be fitted in:\n"
    			+ "* long\n"
    			+ "-12312312312312 can be fitted in:\n"
    			+ "* long\n"
    			+ "4353453 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "42342342342342353456 can't be fitted anywhere.\n"
    			+ "-3534634563456456456456456456456456456456456456456 can't be fitted anywhere.\n"
    			+ "-12343242342342342342342342343 can't be fitted anywhere.\n"
    			+ "-123 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-345345345 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-345345 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "123124342355 can be fitted in:\n"
    			+ "* long\n"
    			+ "234324234234234 can be fitted in:\n"
    			+ "* long\n"
    			+ "23452453453453453 can be fitted in:\n"
    			+ "* long\n"
    			+ "-2345234 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-131231 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-2342342 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-456456 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "17 can be fitted in:\n"
    			+ "* byte\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "9223372036854775808 can't be fitted anywhere.\n"
    			+ "9223372036854775807 can be fitted in:\n"
    			+ "* long\n"
    			+ "-9223372036854775808 can be fitted in:\n"
    			+ "* long\n"
    			+ "-9223372036854775807 can be fitted in:\n"
    			+ "* long\n"
    			+ "4294967296 can be fitted in:\n"
    			+ "* long\n"
    			+ "4294967295 can be fitted in:\n"
    			+ "* long\n"
    			+ "-4294967296 can be fitted in:\n"
    			+ "* long\n"
    			+ "-4294967295 can be fitted in:\n"
    			+ "* long\n"
    			+ "65536 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "65535 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-65536 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-65535 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "256 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "255 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-256 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "-255 can be fitted in:\n"
    			+ "* short\n"
    			+ "* int\n"
    			+ "* long\n"
    			+ "12222222222222222222222222222222222222222221 can't be fitted anywhere.\n"
    			+ "23423424234234 can be fitted in:\n"
    			+ "* long\n"
    			+ "-23123123123123123 can be fitted in:\n"
    			+ "* long\n"
    			+ "-1010000 can be fitted in:\n"
    			+ "* int\n"
    			+ "* long\n";
    	Assert.assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
