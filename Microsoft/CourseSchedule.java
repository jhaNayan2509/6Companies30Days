/*Related topics:--> Graph,kahns algo,topo sort, dfs */
//simple dfs solution

class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++)
            map.put(prerequisites[i][0], new ArrayList<>());
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            map.get(pre[0]).add(pre[1]);
        }
        for(int i=0; i < numCourses; i++){
            if(!dfs(i))
                return false;
        }
        return true;
    }
    public boolean dfs(int course) {
        if (visited.contains(course))
            return false;
        if (map.get(course) == null)
            return true;
        
        visited.add(course);
        List<Integer> dependCourses = map.get(course);
        for (int dCourse : dependCourses) {
            if(!dfs(dCourse))
                return false;
        }
        map.get(course).clear();
        visited.remove(course);
        return true;
    }
}