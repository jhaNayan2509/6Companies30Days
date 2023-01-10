class Solution {
    int max_num = 0;
    
    public int maximumGood(int[][] statements) {
        dfs(statements, new boolean[statements.length], 0, 0);
        return max_num;
    }
    
    private boolean isValid(int[][] statements, boolean[] good, int k) {
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                
                if (statements[i][j] == 1 && !good[j] && good[i]) return false;   
                
                if (statements[i][j] == 0 && good[j] && good[i]) return false;
            }
        }
        
        return true;
    }
    
    private void dfs(int[][] statements, boolean[] good, int i, int count) {
        if (i == good.length) {
            max_num = Math.max(count, max_num);
            return;
        }
       
        if (isValid(statements, good, i)) {
            dfs(statements, good, i + 1, count);
        }
        good[i] = true;
        if (isValid(statements, good, i)) {
            dfs(statements, good, i + 1, count + 1);
        }
        good[i] = false;
    }
    
}