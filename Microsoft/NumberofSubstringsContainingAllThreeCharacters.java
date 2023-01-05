/*Related topics: Hashing,Arrays,sliding window*/
//solution using arrays
class Solution {
    public int numberOfSubstrings(String s) {
        int c=0;
        int[] map = new int[3];
        int l=0;
        for(int r=0;r<s.length();r++){
            map[s.charAt(r) - 'a']++;
            while(map[0] > 0 && map[1] > 0 && map[2] > 0){
                map[s.charAt(l++) - 'a']--;
            }
                c+= l;
        }
        return c;
    }
}