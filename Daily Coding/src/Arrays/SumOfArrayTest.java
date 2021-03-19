package Arrays;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SumOfArrayTest {
	SumOfArray sumOfArray;
	
	@BeforeEach
	void beforeEach() {
		SumOfArray sumOfArray = new SumOfArray();
		this.sumOfArray  = sumOfArray; 
	}
	@Test
	@DisplayName("Single Test")
	void test() {
		int[] expected = {1, 7, 15};
		int[] actual = sumOfArray.sumOfArray(new int[]{1, 3, 4, 5,8,2});
		assertArrayEquals(expected, actual, "Expected " + Arrays.toString(expected) + "But its " + Arrays.toString(actual));
	}
	@Test 
	@DisplayName("Multiple Tests")
	void allTest() {
		assertAll(
				() -> assertArrayEquals(new int[] {}, sumOfArray.sumOfArray(new int[] {})),
				() -> assertArrayEquals(new int[] {1,5}, sumOfArray.sumOfArray(new int[] {1,2,3})),
				() -> assertArrayEquals(new int[] {1,5,4}, sumOfArray.sumOfArray(new int[] {1,2,3,4}))
			
		);
	}

}
