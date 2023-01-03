/*Problem Link : https://leetcode.com/problems/perfect-rectangle/description/ */

class Solution{

    public boolean isRectangleCover(int[][] rectangles) {

        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
         HashSet<String> set = new HashSet<String>();
        int x1 = Integer.MAX_VALUE;
        int x2 = 0;
        int y1 = Integer.MAX_VALUE;
        int y2 = 0;
        
        
        int area = 0;
        
        for (int[] arr : rectangles) {
            x1 = Math.min(arr[0], x1);
            y1 = Math.min(arr[1], y1);
            x2 = Math.max(arr[2], x2);
            y2 = Math.max(arr[3], y2);
            
            area += (arr[2] - arr[0]) * (arr[3] - arr[1]);
            
            String s1 = arr[0] + " " + arr[1];
            String s2 = arr[0] + " " + arr[3];
            String s3 = arr[2] + " " + arr[3];
            String s4 = arr[2] + " " + arr[1];
            
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        
        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;
        
        return area == (x2-x1) * (y2-y1);
    }
}

/*Submission Link: https://leetcode.com/problems/perfect-rectangle/submissions/870589203/ */