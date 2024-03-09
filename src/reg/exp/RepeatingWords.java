package reg.exp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatingWords {

	private static String removeRepeatedWords(String input){
	    Set<String> uniqueWords = Arrays
	    		.stream(input.split(" "))
	    		.map(w -> w.toLowerCase())
	    		.collect(Collectors.toSet());  
		return uniqueWords.toString();
		
	    }
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int numSentences = Integer.parseInt(in.nextLine());

	        while (numSentences-- > 0) {
	            String input = in.nextLine();
	            String result = removeRepeatedWords(input);
	            System.out.println(result);
	        }

	        in.close();
	    }

}