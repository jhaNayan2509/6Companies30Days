/*Problem link:--> https://leetcode.com/problems/rotate-function/description/ */

class Solution {
 
    public int maxRotateFunction(int[] A) {
        int F = 0;
        int Asum = 0;
        int count = A.length;
        for (int i=0;i<count;i++){
            F+=A[i]*i;
            Asum+=A[i];
        }
        int max=F;
        for (int j=1;j<count;j++){
            F=F+Asum-A[count-j]*count;
            max=Math.max(max,F);
        }
        return max;
    }
}

/*Submission link :--> https://leetcode.com/problems/rotate-function/submissions/870555532/ */