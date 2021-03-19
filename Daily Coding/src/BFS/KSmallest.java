package BFS;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KSmallest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		int[] array = {10,4,5,3,7,9,6,12};
		int k =8;
		KSmallest sol = new KSmallest();
		System.out.println(sol.kSmallest(list,array,k,0,array.length -1));
	}
	public List<Integer> kSmallest(List<Integer> list, int[] array, int k, int left, int right) {
		if(list.size() >= k) {
			return list;
		}
		int pos = partition(array, left, right);
		if(pos > k) {
			kSmallest(list, array, k, list.size(), pos - 1);
		}
		else if(pos <= k) {
			addElement(list, array, left, pos - 1);	
		}
		kSmallest(list, array, k, list.size(), right);
		return list;
		
	}
	public int partition(int[] array, int left, int right) {
		int pivotIndex = findPivot(left, right);
		int pivot = array[pivotIndex];
//		swap(array, pivotIndex, right);
		int i = left;
		int j = right;
		while (i <= j) {
			if(array[i] <= pivot) {
				i++;
			}else if(array[j] > pivot) {
				j--;
			}else {
				swap(array, i++, j--);
			}
		}
//		swap(array, i, right);
		return i;
	}
	public List<Integer> addElement(List<Integer> list, int[] array, int start, int end){
		for(int i = start; i <= end; i++) {
			list.add(array[i]);
		}
		return list;
	}
	public int findPivot(int left, int right) {
		Random rand = new Random();
		return left + rand.nextInt(right - left + 1);
	}
	public int[] swap(int[] array, int leftSide, int rightSide) {
		int temp;
		temp = array[leftSide];
		array[leftSide] = array[rightSide];
		array[rightSide] = temp;
		return array;
	}

}
