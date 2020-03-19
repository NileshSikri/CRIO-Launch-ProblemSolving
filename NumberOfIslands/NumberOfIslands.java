import java.io.*;
import java.util.*;

class NumberOfIslands {

    // Implement your solution by completing the below function
    public int numIslands(char[][] grid) {

        int n = grid.length;
        if(n==0)
            return 0;
        int m = grid[0].length;
        if(m==0)
            return 0;
        
        int ans =0;
        for(int i=0;i<n;i++)
        {
            m = grid[i].length;
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    ans++;
                    dfs(grid,i,j,n,m);
                }
            }
        }
        return ans;
    }

    public void dfs(char grid[][],int i,int j,int n,int m)
        {
            if(i<0 || i>=n || j<0 || j>=m || grid[i][j]=='0')
                return;
            grid[i][j]='0';
            dfs(grid,i-1,j,n,m);
            dfs(grid,i+1,j,n,m);
            dfs(grid,i,j-1,n,m);
            dfs(grid,i,j+1,n,m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        char[][] grid = new char[rows][columns];

        for (int i = 0; i < rows; ++i) {
            String s = scanner.next();
            for (int j = 0; j < columns; ++j) {
                grid[i][j] = s.charAt(j);
            }
        }
        scanner.close();
        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}