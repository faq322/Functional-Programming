package Recursion;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


class SolutionTest {

	@Test
	void test_8653() {
		assertEquals(22, Solution.superDigit(8653));
	}
	
	@Test
	void test_3568() {
		assertEquals(22, Solution.superDigit(3568));
	}
	
	@Test
	void test_1() {
		assertEquals(1, Solution.superDigit(1));
	}
	
	@Test
	void test_24() {
		assertEquals(6, Solution.superDigit(24));
	}
	
	@Test
	void test_100() {
		assertEquals(1, Solution.superDigit(100));
	}
	
	@Test
	void test_67349155() {
		assertEquals(40, Solution.superDigit(67349155));
	}
	
	@Test
	void test_1111111111() {
		assertEquals(10, Solution.superDigit(1111111111));
	}

}
