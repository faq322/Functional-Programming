package imperative;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectNumber {
	public static enum STATE {
		PERFECT,
		DEFICIENT,
		ABUNDANT,
		ERROR;
	}
	
	public static void main(String[] args) {
	    Scanner input=new Scanner(System.in);
	    System.out.println("Enter the number:");
	    int number=input.nextInt();
	    input.close();
	    
        System.out.println(process(number));        
	}
	
	public static Set<Integer> divisors(int n) {
		Set<Integer> divisors = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            } 
        }
        return divisors;
	}
	
	public static STATE process(int n) {
		Set<Integer> divisors = divisors(n);
		int sum = 0;
		for (Integer divisor : divisors) {
			if (divisor!=n) {
				sum += divisor; 
			}
		}

		if (sum == n) 
			return STATE.PERFECT;
		else if (sum < n) 
			return STATE.DEFICIENT;
		else if (sum > n)
			return STATE.ABUNDANT;
		
		return STATE.ERROR;
	}
}