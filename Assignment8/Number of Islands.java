class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null || grid.length == 0) 
            return count;
            
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    isIsland(i, j, grid);
                }
            }
        }
        return count;
    }
    
    private void isIsland(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length
           || c < 0 || c >= grid[0].length) return;
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';
        isIsland(r + 1, c, grid);
        isIsland(r - 1, c, grid);
        isIsland(r, c + 1, grid);
        isIsland(r, c - 1, grid);
    }
public static void main(String[] args){
    	char[][] list= {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
    	Solution soln = new Solution();
    	System.out.println(soln.numIslands(list));
    	
    	}
}
