/*Related topics: hashmap and geometry(slope concept) */
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        int length = points.length;
        if (length <= 2) return length;
        int result = 0;
        for (int i = 0;i<points.length;i++){
            Map<Double, Integer> map = new HashMap<>();
            int count = 1;
            int same = 0;
            for (int j = 0;j<points.length;j++){
               
                if(j != i){
                  
                    int firstX = points[i][0];
                    int firstY = points[i][1];
                    
                  
                    int secondX = points[j][0];
                    int secondY = points[j][1];
                    
                  
                    if (firstX == secondX && firstY == secondY){ 
                        same++;
                        continue;
                    }
                    
                    if (firstX == secondX) {
                        count++;                    
                        continue;
                    }
                   
                    double k = (double)(secondY - firstY) / (double)(secondX - firstX);
                    map.put(k, map.getOrDefault(k, 1)+1);
                    
                    result = Math.max(result, map.get(k) + same);
                }
            }
            
            result = Math.max(result, count);
        }
        return result;
    }
}