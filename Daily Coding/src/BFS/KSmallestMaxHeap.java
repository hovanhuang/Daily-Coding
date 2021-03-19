package BFS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class MyComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer i1, Integer i2) {
		return (i1 < i2)? 1 : (i1 == i2)? 0: -1;
	}
}

public class KSmallestMaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}
	public int[] kSmallest(int[] array, int k) {
		// Write your solution here
		int[] result = new int[k];
		if(k == 0 || array == null){
			return result;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new MyComparator());
		for(int i = 0; i <= k - 1; i++){
			maxHeap.offer(array[i]);
		}
		for (int i = k; i <= array.length - 1; i++){
			if(array[i] < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		for(int i = 0; i <= k - 1; i++){
			result[i] = maxHeap.poll();
		}
		Arrays.sort(result);
		return result;

	}



}
