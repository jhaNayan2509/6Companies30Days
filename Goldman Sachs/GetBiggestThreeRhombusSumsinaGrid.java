class Solution{
    public int[] getBiggestThree(int[][] grid) {
    int maxLen = grid.length / 2;
    PriorityQueue<Integer> pq = new PriorityQueue();
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (!set.contains(grid[i][j])) {
                set.add(grid[i][j]);
                pq.add(grid[i][j]);
            }
            if (pq.size() > 3) {
                pq.poll();
            }
            for (int k = 1; k <= maxLen && i >= k && j >= k && i + k < grid.length && j + k < grid[0].length; k++) {
                int sum = getSum(grid, i, j, k);
                if (!set.contains(sum)) {
                    set.add(sum);
                    pq.add(sum);
                }
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }
    }
    int[] threeMaxSums = new int[pq.size()];
    int pos = pq.size() - 1;
    while (!pq.isEmpty()) {
        threeMaxSums[pos] = pq.poll();
        pos--;
    }
    return threeMaxSums;
}

public int getSum(int[][] grid, int i, int j, int k) {
    int count = 0;
    for (int l = 0; l < k + 1; l++) {
        count += grid[i + l][j - k + l] + grid[i + l][j + k - l] + grid[i - l][j - k + l] + grid[i - l][j + k - l];
    }
    count -= grid[i + k][j] + grid[i - k][j] + grid[i][j + k] + grid[i][j - k];
    return count;
}

}