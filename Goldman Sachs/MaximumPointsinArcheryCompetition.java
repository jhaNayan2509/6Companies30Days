/*Related Topic: Recursion */
class Solution {
    int bobsPoints = 0;
    int maxBobsPoints = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int index = 0; 
        int[] ans1 = findMaxBobpoints(numArrows, aliceArrows, index, bobsPoints);
        int[] res = new int[12];
		
        for(int i = 0; i < ans1.length - 1; ++i){ 	
            res[i] = ans1[i];
        }
        return res;
    }
    
    private int[] findMaxBobpoints(int numArrows, int[] aliceArrows, int index,int bobsPoints){
        if(index == 12 ||  numArrows  <= 0){
            maxBobsPoints  = Math.max(bobsPoints, maxBobsPoints);
            int[] ans =  new int[13]; 
            ans[12] = bobsPoints;
            if(numArrows > 0){  
                ans[0] = numArrows;
            }
            return ans;
        }

        int[] sectionSelected = new int[13];
        if(numArrows - (aliceArrows[index] + 1) >= 0){
			sectionSelected  = findMaxBobpoints(numArrows - (aliceArrows[index] + 1), aliceArrows, index + 1, bobsPoints + index);
			sectionSelected[index] += aliceArrows[index] + 1;
        }
        
        int[] sectionSkipped = findMaxBobpoints(numArrows, aliceArrows, index + 1, bobsPoints);
        
        if(sectionSelected[12] == maxBobsPoints){ 
            return sectionSelected;
        }
        else{
            return sectionSkipped;
        }
        
        
    }
}