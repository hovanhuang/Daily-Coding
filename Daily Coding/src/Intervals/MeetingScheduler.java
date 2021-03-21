import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//LeetCode 1229
class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        if(slots1 == null || slots2 == null || duration == 0){
            return new ArrayList<>();
        }
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
        int id1 = 0, id2 = 0;
        while(id1 < slots1.length && id2 < slots2.length){
            int start = Math.max(slots1[id1][0], slots2[id2][0]);
            int end = Math.min(slots1[id1][1], slots2[id2][1]);
            if(end - start >= duration){
                    return Arrays.asList(start, start + duration);
            }
            if(slots1[id1][1] > slots2[id2][1]){
                id2++;
            }else{
                id1++;
            }
        }
        return new ArrayList<>();
        
        
        

    }
}