package DFS;
import java.util.ArrayList;
import java.util.List;

public class PrintIf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintIf sol = new PrintIf();
		sol.printIf(3);

	}
	void printIf(int n){
		List<String> result = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		allValidCom(result, sb, n, n);
		int size = result.size();
		for(int i = 0; i <= size - 1; i++){
			System.out.println("Solution" + i);
			printSol(result.get(i), n);
		}
	}
	void allValidCom(List<String> result, StringBuilder sb, int leftRem, int rightRem){
		if(leftRem == 0 && rightRem == 0){
			result.add(sb.toString());
			return;
		}
		if(leftRem >0){
			sb.append("{");
			allValidCom(result, sb, leftRem - 1, rightRem);
			sb.deleteCharAt(sb.length() - 1);
		}
		if(rightRem > leftRem){
			sb.append("}");
			allValidCom(result, sb, leftRem, rightRem - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	void printSol(String input, int n){
		int count = 0;
		for(int i = 0; i <= 2*n - 1; i++){
			if(input.charAt(i) == '{'){
				printSpace(2*count);
				System.out.println("if{");
				count++;
			}else{
				printSpace(2*count);
				System.out.println("}");
				count--;
			}		 
		}
	}
	void printSpace(int n){
		while(n >0){
			System.out.print(" ");
			n--;
		}
	}

}
