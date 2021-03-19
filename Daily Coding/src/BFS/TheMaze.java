package BFS;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TheMaze {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj){
            if(obj == this) return true;
            if(!(obj instanceof Pair)) return false;
            Pair p = (Pair)obj;
            if(p.x == this.x && p.y == this.y) return true;
            return false;
        }
        @Override
        public int hashCode(){
            return 31 * this.x + this.y;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = {0, 4};
		int[] destination = {0, 3};
		TheMaze sol = new TheMaze();
		System.out.print(sol.hasPath(maze, start, destination));
	}
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        queue.add(new Pair(start[0], start[1]));
        visited.add(new Pair(start[0], start[1]));
        Pair des = new Pair(destination[0], destination[1]);
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int i = 0; i < direction.length; i++){
                Pair nei = getNeighbor(maze, cur, direction[i][0], direction[i][1]);
                if(nei.equals(des)){
                    return true;
                }else{
                    if(!nei.equals(cur) && !visited.contains(nei)){
                        visited.add(nei);
                        queue.add(nei);
                    }
                }
            }
        }
        return false;
    }
    public Pair getNeighbor(int[][] maze, Pair start, int dirX, int dirY){
        int newRow = start.x + dirX;
        int newCol = start.y + dirY;
        while(newRow >= 0 && newRow < maze.length && newCol < maze[0].length && newCol >= 0 && maze[newRow][newCol] ==0){
            newRow += dirX;
            newCol += dirY;
        }
        return new Pair(newRow - dirX, newCol - dirY);
    }

}
