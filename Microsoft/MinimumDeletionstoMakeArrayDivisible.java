/*Related Topics: Maths(GCD),Priority queue,etc.*/
class Solution {

    public int minOperations(int[] nums, int[] numsDivide) {
        
        int result = 0;
        
        
        Arrays.sort(nums);
        int div = getDiv(numsDivide);
        
        for(int i = 0; i< nums.length; i++) {
            
            if(div%nums[i]== 0) return result;
            result++;
        }
    
        return -1;
    }
    
    public int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }    
    
    public int getDiv(int[] arr) {
        
        int div = arr[0];
        
        for(int num : arr) {
            div = getGCD(div, num);
        }
        
        if(div == 1) return 1;
        
        return div;
    }
    }