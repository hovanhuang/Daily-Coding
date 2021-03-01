import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class PalindromePairsTest {

	@Test
	void test() {
		PalindromePairs p = new PalindromePairs();
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(0, 1));
		list.add(Arrays.asList(1, 0));
		String[] input = {"bat","tab","cat"};
		List<List<Integer>> result = p.palindromePairs(input);
		assertEquals(list, result);
	}

}
