/*Related Topic : Divide and Conquer, Fenwick Tree,etc.*/
//O(nlogn) solution: using divide and conquer
class Solution {
       
    int[] nums1, nums2, indicies1;
    int[] left, right;
    
    public long goodTriplets(int[] nums1, int[] nums2) {
        int len = nums1.length;
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        indicies1 = new int[len];
        for (int i = 0; i < len; ++ i) {
            indicies1[nums1[i]] = i;
        }
        
        left = new int[len];
        right = new int[len];
        divideAndConquer(0, len - 1);
        
        long output = 0L;
        for (int i = 0; i < len; ++ i) {
            output += (long)left[i] * (long)right[i];
        }
        
        return output;
    }
    
    public void divideAndConquer(int l, int r) {
        if (l == r) {
            return;
        }
        
        
        int mid = l + (r - l) / 2;
        divideAndConquer(l, mid);
        divideAndConquer(mid + 1, r);
        
        
        int i = 0, j = 0, k = 0;
        int[] temp1 = new int[mid - l + 1];
        int[] temp2 = new int[r - mid];
        
        System.arraycopy(nums2, l, temp1, 0, mid - l + 1);
        System.arraycopy(nums2, mid + 1, temp2, 0, r - mid);
        
        int[] temp = new int[r - l + 1];
        
       
        while (i < temp1.length && j < temp2.length) {
            if (indicies1[temp1[i]] < indicies1[temp2[j]]) {
                temp[k] = temp1[i];
                ++ i;
            } else {
                temp[k] = temp2[j];
                left[temp2[j]] += i;
                ++ j;
            }
            ++ k;
        }
        
        while (i < temp1.length) {
            temp[k] = temp1[i];
            ++ i;
            ++ k;
        }
        
        while (j < temp2.length) {
            temp[k] = temp2[j];
            left[temp2[j]] += i;
            ++ j;
            ++ k;
        }
        
        System.arraycopy(temp, 0, nums2, l, r - l + 1);
        
        
        i = temp1.length - 1;
        j = temp2.length - 1;
        k = temp.length - 1;
        while (i >= 0 && j >= 0) {
            if (indicies1[temp1[i]] > indicies1[temp2[j]]) {
                right[temp1[i]] += temp2.length - j - 1;
                -- i;
            } else {
                -- j;
            }
        }
        
        while (i >= 0) {
            right[temp1[i]] += temp2.length - j - 1;
            -- i;
        }
    }
}