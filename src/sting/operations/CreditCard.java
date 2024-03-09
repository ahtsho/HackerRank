package sting.operations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCard {

	public static void main(String[] args) {
		String input = "1234-2342-4563-3345";
		Pattern p = Pattern.compile("(\\d{4})-+");
		Matcher m = p.matcher(input);
		if(m.find()) {
			System.out.println(m.group());
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			
		}
	}
}
