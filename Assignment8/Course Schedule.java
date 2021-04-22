public class Solution{
    // BFS, delete the indgree = 0 courses 1 by 1, until not doable, 
    // check if courses deleted = total course number
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0)
            return true;
        int[] inDegree = new int[numCourses];
        List<List<Integer>> pre = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++)
            pre.add(new ArrayList<>());
        
        for (int[] courses : prerequisites) {
            pre.get(courses[1]).add(courses[0]);
            inDegree[courses[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            count++;
            for (int prev : pre.get(curCourse)) {
                inDegree[prev]--;
                if (inDegree[prev] == 0)
                    queue.offer(prev);
            }
            
        }
        return count == numCourses;
    }
 public static void main(String[] args){
    	int[][] prerequisites= {{1,0}};
    	
      Solution soln = new Solution();
    	System.out.println(soln.canFinish(2, prerequisites));
    
     }
}
