package functional;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

	public static enum STATE {
		DEFICIENT,
		PERFECT,
		ABUNDANT,
		ERROR
	}
	
	public static void main(String[] args) {
	    Scanner input=new Scanner(System.in);
	    System.out.println("Enter the number:");
	    int number=input.nextInt();
	    input.close();
	    
        System.out.println(process(number));        
	}
	
	public static Set<Integer> divisors(Integer n) {
		Set<Integer> divisors = new HashSet<>();
		divisors.addAll(
			IntStream
				.rangeClosed(1, (int) Math.ceil(Math.sqrt(n)))
				.filter(i -> n % i == 0)
				.flatMap(i -> IntStream.of(i, (int)(n/i)))
				.boxed()
				.collect(Collectors.toCollection(HashSet::new))
		);
		return divisors;
	}
	
	public static STATE process(Integer n) {
		Set<Integer> divisors = divisors(n);
		int divisors_sum = divisors
				.parallelStream()
				.filter(i -> i != n)
				.reduce(0, Integer::sum);
		
		if (divisors_sum == n) 
			return STATE.PERFECT;
		else if (divisors_sum < n) 
			return STATE.DEFICIENT;
		else if (divisors_sum > n)
			return STATE.ABUNDANT;
		
		return STATE.ERROR;
	}
}
