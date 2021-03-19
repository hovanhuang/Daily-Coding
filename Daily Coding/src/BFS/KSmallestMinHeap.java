package BFS;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KSmallestMinHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10,4,5,3,7,9,6,12,19,18,20,43,21,53,0, -1 ,100};
		PriorityQueue<Integer> newHeap = new PriorityQueue<>();
		for (int i = 0; i < array.length; i++) {
			newHeap.offer(array[i]);
		}
		System.out.println(newHeap.poll());
		System.out.println(newHeap.poll());
		
	}

}
