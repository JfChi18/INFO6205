class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> zeroQueue = new LinkedList();
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        for (int i = 0; i < rowCount; ++i) {
            for (int j = 0; j < colCount; ++j) {
                if (matrix[i][j] == 0) zeroQueue.add(new int[]{i,j});
            }
        }
        while (!zeroQueue.isEmpty()) {
            int[] zeroPosition = zeroQueue.poll();
            int r = zeroPosition[0];
            int c = zeroPosition[1];
            for (int i = 0; i < colCount; ++i) {
                matrix[r][i] = 0;
            }
            for (int i = 0; i < rowCount; ++i) {
                matrix[i][c] = 0;
            }
        }
    }
}
