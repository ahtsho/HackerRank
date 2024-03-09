package sting.operations;

import java.util.Arrays;

public class StringTokens {
	public static void main(String[] args) {
        
        //String s = "Hello, thanks for attempting this problem! Hope it will help you to learn java! Good luck and have a nice day!\n";
		String s = "       _YES      leading spaces        are valid,    problemsetters are    ?????     evillllll";
        
        String [] tokens = Arrays.stream(s.split("\\s*[ !,?._'@]*[ !,?._'@]+\\s*",0)).filter(w -> !w.isEmpty()).toArray(String[]::new);
        System.out.println(tokens.length);
        for (int i = 0; i < tokens.length; i++){
            System.out.println(tokens[i]);
        }

    }
}
