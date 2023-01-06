/*Topic: Maths */
class Solution {
    public int trailingZeroes(int n) {
        if (n < 25) return n / 5;
        int count = n / 5;
        return count + trailingZeroes(count);
    }
}