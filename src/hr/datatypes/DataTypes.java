package hr.datatypes;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

class DataTypes {
	public static void main(String[] argh) {
		int SIGN_LENGTH = 1;
		int BYTE_RANGE = (int) Math.pow(2, 8 - 1);
		int SHORT_RANGE = (int) Math.pow(2, 16 - 1);
		double INT_RANGE = Math.pow(2, 32 - 1);
		BigInteger LONG_RANGE = BigInteger.valueOf(2).pow(64 - 1);
		/*
		 * System.out.println("Byte = ["+ -BYTE_RANGE+", "+(BYTE_RANGE -
		 * SIGN_LENGTH)+"]"); System.out.println("Short = ["+
		 * -SHORT_RANGE+", "+(SHORT_RANGE - SIGN_LENGTH)+"]");
		 * System.out.println("Int = ["+ -INT_RANGE+", "+(INT_RANGE - SIGN_LENGTH)+"]");
		 * System.out.println("Long = [-"+
		 * LONG_RANGE.toString()+", "+(LONG_RANGE.subtract(BigInteger.ONE))+"]");
		 */

		Scanner sc = new Scanner(System.in);
		int testCaseNumber = sc.nextInt();

		for (int i = 0; i < testCaseNumber; i++) {
			try {
				long x = sc.nextLong();
				System.out.println(x + " can be fitted in:");
				if (x >= -BYTE_RANGE && x <= BYTE_RANGE - SIGN_LENGTH)
					System.out.println("* byte");
				if (x >= -SHORT_RANGE && x <= SHORT_RANGE - SIGN_LENGTH)
					System.out.println("* short");
				if (x >= -INT_RANGE && x <= INT_RANGE - SIGN_LENGTH)
					System.out.println("* int");
				if (BigInteger.valueOf(x).compareTo(LONG_RANGE.negate()) >= 0
						&& BigInteger.valueOf(x).compareTo(LONG_RANGE.subtract(BigInteger.valueOf(SIGN_LENGTH))) <= 0) {
					System.out.println("* long");
				}
			} catch (Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}
		}
	}
}
