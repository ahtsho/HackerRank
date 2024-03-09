package sting.operations;

public class Anagrams {
	static boolean isAnagram(String a, String b) {
        try{
            char[] aList = new char[a.length()];
            char[] bList = new char[a.length()];
            a.getChars(0, a.length(), aList, 0);
            b.getChars(0, b.length(), bList, 0);
            System.out.println(sort(aList));
            System.out.println(sort(bList));
            
            for(int i = 0; i < a.length(); i++){
                System.out.println(a.charAt(i));
          
                System.out.println(b.charAt(i));
            }
            return true;
        } catch (Exception e){
            return false;
        }
    }
    static boolean isSorted(char[] list){
        for (int i = 0; i < list.length-1; i++){
            if (list[i] > list[i+1]) return false;
        }
        return true;
    }
    static char[] sort(char[] list){
        while(!isSorted(list)){
            for(int i = 0; i < list.length-1; i++){
                if (list[i] > list[i+1]){
                    char x = list[i];
                    list[i] = list[i+1];
                    list[i+1] = x;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        
        
        String a ="anagram"; 
        String b = "margana";
        
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
