package Arrays;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MountainPeaks {
	class Node{
		int val;
		Node(int val){
			this.val = val;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3, 4, 2, 5, 8, 1};
		MountainPeaks sol = new MountainPeaks();
		System.out.println(Arrays.toString(sol.findMinimumPeaks(input)));
	}
	private int[] findMinimumPeaks(int[] input) {
		if(input == null || input.length == 0) {
			return new int[0];
		}
		if(input.length == 1) {
			return input;
		}
		LinkedList<Node> list = new LinkedList<>();
		for(int i = 0; i < input.length; i++) {
			list.add(new Node(input[i]));
		}
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a, b) -> Integer.compare(a.val, b.val));
		minHeap = firstPeaks(list, minHeap);
		list.addLast(new Node(Integer.MIN_VALUE));
		list.addFirst(new Node(Integer.MIN_VALUE));
		int[] result = new int[input.length];
		int id = 0;
		while(list.size() > 4) {
			Node cur = minHeap.poll();
			int curId = list.indexOf(cur);
			result[id++] = cur.val;
			if(curId == 1 && list.get(curId + 1).val > list.get(curId + 2).val) {
				minHeap.add(list.get(curId + 1));
			}else if(curId == list.size() - 2 && list.get(curId - 1).val > list.get(curId - 2).val) {
				minHeap.add(list.get(curId - 1));
			}else if(curId != 1 && curId != list.size() - 2 && list.get(curId + 1).val > list.get(curId + 2).val && list.get(curId + 1).val > list.get(curId - 1).val) {
				minHeap.add(list.get(curId + 1));
			}else if(curId != 1 && curId != list.size() - 2 && list.get(curId - 1).val > list.get(curId - 2).val && list.get(curId - 1).val > list.get(curId + 1).val) {
				minHeap.add(list.get(curId - 1));
			}
			list.remove(curId);
		}
		
		result[id++] = Math.max(list.get(1).val, list.get(2).val);
		result[id] = Math.min(list.get(1).val, list.get(2).val);
		return result;
		
	}
	private PriorityQueue<Node> firstPeaks(LinkedList<Node> list, PriorityQueue<Node> minHeap) {
		int n = list.size();
		for(int i = 0; i < list.size(); i++) {
			if(i == 0 && list.get(0).val > list.get(i + 1).val) {
				minHeap.add(list.get(i));
			}else if(i == n - 1 && list.get(n - 1).val > list.get(n - 2).val) {
				minHeap.add(list.get(i));
			}else if(i != 0 && i != n - 1 && list.get(i).val > list.get(i - 1).val && list.get(i).val > list.get(i + 1).val){
				minHeap.add(list.get(i));
			}
		}
		return minHeap;
		
	}

}
