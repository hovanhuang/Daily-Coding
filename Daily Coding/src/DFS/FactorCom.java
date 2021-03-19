package DFS;
import java.util.ArrayList;
import java.util.List;

public class FactorCom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorCom sol = new FactorCom();
		int target = 12;
		System.out.println(sol.combinations(target));

	}
	public List<List<Integer>> combinations(int target) {
		// Write your solution here
		List<Integer> factor = findFactor(target);
		List<List<Integer>> result = new ArrayList();
		List<Integer> product = new ArrayList();
		allFactor(result, product, factor, 0, target);
		return result;
	}
	private void allFactor(List<List<Integer>> result, List<Integer> product,List<Integer> factor,
			int level, int quotient){
		if(level == factor.size()){
			if(quotient == 1) {
				result.add(new ArrayList(product));
			}
			return;
		}
		allFactor(result, product, factor, level + 1, quotient);
		int curFactor = factor.get(level);
		int size = product.size();
		while(quotient % curFactor == 0) {
			product.add(curFactor);
			quotient /= curFactor;
			allFactor(result, product, factor, level + 1, quotient);
		}
		product.subList(size, product.size()).clear();
	}
	private List<Integer> findFactor(int n){
		List<Integer> factor = new ArrayList<>();
		for(int i = 2; i <= n / 2; i++){
			if(n % i == 0){
				factor.add(i);
			}
		}
		return factor;
	}

}
