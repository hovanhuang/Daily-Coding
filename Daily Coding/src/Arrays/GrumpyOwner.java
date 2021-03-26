package Arrays;
//leetcode 1052
public class GrumpyOwner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if(customers == null || customers.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int allSatisfy = 0;
        int count = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                allSatisfy += customers[i];
            }else{
                count += customers[i];
            }
            if(i >= X){
                if(grumpy[i - X] == 1) count -= customers[i - X];
            }
            max = Math.max(max, count);
        }
        return allSatisfy + max;
    }

}
