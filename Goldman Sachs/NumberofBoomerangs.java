/*Related topic : Map*/
class Solution {
    public int numberOfBoomerangs(int[][] points) {
     int ans = 0;
     Map<Integer,Integer> map = new HashMap<Integer,Integer>();
     for(int i=0;i<points.length;i++){
         for(int j=0;j<points.length;j++){
             if(i==j) continue;
             int numOfPoints = map.merge((points[i][0]-points[j][0])*(points[i][0]-points[j][0]) + 
                             (points[i][1]-points[j][1])*(points[i][1]-points[j][1]),1,Integer::sum);
            ans += (numOfPoints-1);                                                     
         }
       map.clear();
     }
        return ans*2;
    }
}