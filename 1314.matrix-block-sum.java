/*
 * @lc app=leetcode id=1314 lang=java
 *
 * [1314] Matrix Block Sum
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        PreSum preSum = new PreSum(mat);
        int[][] ans = new int[mat.length][mat[0].length];
        
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++) {
                int row1 = Math.max(0, i - k);
                int col1 = Math.max(0, j - k);
                int row2 = Math.min(i + k, mat.length - 1);
                int col2 = Math.min(j + k, mat[0].length - 1);
                
                ans[i][j] = preSum.sumRegion(row1, col1, row2, col2);
                
            }
        return ans;

    }

    
}

class PreSum {
    public int[][] sums;

    public PreSum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        sums = new int[m+1][n+1];
        for(int i = 1; i <= m; i++)
            for(int j = 1; j <= n; j++)
                sums[i][j] = sums[i-1][j] + sums[i][j-1] + mat[i-1][j-1] - sums[i-1][j-1];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        return sums[row2+1][col2+1]
             - sums[row1][col2+1]
             - sums[row2+1][col1]
             + sums[row1][col1];
    }
}

// @lc code=end

