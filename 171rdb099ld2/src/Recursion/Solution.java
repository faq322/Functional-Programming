package Recursion;

import java.util.Scanner;

//"099 % 2 = 1 => Task: Recursive Digit Sum 
public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.print("Enter the number:");
        int number = input.nextInt();
        input.close();
        System.out.println(superDigit(number));  
	}
	
    static long superDigit(long x) {
    	return (x==0) ? 0 : x % 10 + superDigit(x /10);
    }
}
