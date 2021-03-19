package DFS;

public class FindSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] input = {'a', 'b', 'c'};
		StringBuilder solutionPrefix = new StringBuilder();
		find(input, 0, solutionPrefix);
		System.out.println(solutionPrefix);
		
	}
	static void find (char[] input, int index, StringBuilder solutionPrefix) {
		if(index == input.length) {
			System.out.println(solutionPrefix);
			return;
		}
		solutionPrefix.append(input[index]);
		find(input, index + 1, solutionPrefix);
		solutionPrefix.deleteCharAt(solutionPrefix.length() - 1);
		find(input, index + 1, solutionPrefix);
	}

}
