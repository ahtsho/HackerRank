package sttic.initializer;

import java.util.Scanner;

public class StaticInitilizer {

static Scanner sc;
static int B;
static int H;
static boolean flag;
static {
    try{
        sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        if ( B <=0 || H <= 0 ) {
        	throw new Exception("Breadth and height must be positive");
        }
        flag = true;  
    } catch (Exception e){
     System.out.println(e.getMessage());
    }
}

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

