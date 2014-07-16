package caesar_cipher;
import java.util.Scanner;

/**
 *
 * @author todyerutz @ plainintricacy.wordpress.com
 * Java program that simulates an encryption device based on the Caesar Cipher:
 * https://en.wikipedia.org/wiki/Caesar_cipher
 */
public class Caesar_Cipher {
    
    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter your message:");
            String inText = input.nextLine();
            char[] arr = inText.toUpperCase().toCharArray();
            System.out.println("Please enter your shift number.");
            System.out.println("Positive integers for right shift, negative integers for left shift.");
            int sKey = Integer.parseInt(input.nextLine());
            System.out.println("Encrypted message:");
            encrypt(arr, sKey);
            System.out.println();
        }
    
    }
    
    public static boolean isLetter(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return true;
            }
        }
        return false;
    }
    
    public static int Lpos(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return i;
            }
        }
        return 0;
    }
    
    public static int Apos(int x){
        if(x>alphabet.length()){
            return x-alphabet.length();
        }else
            if(x<0){
                return alphabet.length()+x;
            }        
        return x;
    }
            
    public static void encrypt(char[] a, int x){
        for(int i=0; i<a.length; i++){
            if(isLetter(a[i])){
                a[i] = alphabet.charAt(Lpos(alphabet.charAt(Apos(Lpos(a[i])+x))));
            }
        }
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
}
