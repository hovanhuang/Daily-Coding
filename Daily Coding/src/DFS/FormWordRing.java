package DFS;

public class FormWordRing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FormWordRing sol = new FormWordRing();
		String[] input = {"a","bc","c","ddb","cd","da","aad"};
		System.out.println(sol.formRing(input));
	}
	public boolean formRing(String[] input) {
		// Write your solution here
		return ring(input, 0);
	}
	public boolean ring(String[] input, int index){
		if(index == input.length){
			String last = input[input.length - 1];
			if(input[0].charAt(0) == last.charAt(last.length() - 1)){
				return true;
			}
			return false;
		}
		for(int i = index; i < input.length; i++){
			swap(input, index, i);
			if(index == 0 || checkConcatenate(input[index - 1], input[index])){
				if(ring(input, index + 1)){
					return true;
				}
			}
			swap(input, index, i);
		}
		return false;
	}
	public void swap(String[] input, int left, int right){
		String temp  = input[left];
		input[left] = input[right];
		input[right] = temp;
	}
	public boolean checkConcatenate(String str1, String str2){
		if(str1.charAt(str1.length() - 1) == str2.charAt(0)){
			return true;
		}
		return false;
	}

}
