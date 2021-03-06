import java.io.*;
import java.util.*;

class MatrixTraversal  {

  // complete the below function implementation
  public List<Integer> valueAtNewPosition(int[][] matrix, int currX, int currY, int dir, int steps) {
    List<Integer> lst = new ArrayList<Integer>();
    int n = matrix.length;
    int flag=0;
    for(int i = 0; i < n; i++)
    {
      int m = matrix[i].length;
      for(int j = 0; j < m; j++)
      {
        if(i == currX && j == currY)
        {
          int s=0;
          while(s<steps){
            if(dir==1)
            j=j+1;
            if(dir==2)
            i=i+1;
            if(dir==3)
            j=j-1;
            if(dir==4)
            i=i-1;

            if(i>=n || i<0 || j>=m || j<0)
            {
              lst.clear();
              lst.add(-1);
              flag=1;
              break;
            }
            else
            lst.add(matrix[i][j]);
            s++;
          }
          if(flag==1)
          break;
        }
      }
      if(flag==1)
      break;
    }
    return lst;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    int currPosX = scanner.nextInt();
    int currPosY = scanner.nextInt();
    int dirToMove = scanner.nextInt();
    int stepsToMove = scanner.nextInt();

    scanner.close();
     List<Integer> result = new MatrixTraversal().valueAtNewPosition(matrix, currPosX, currPosY, dirToMove, stepsToMove);

    for (int i = 0; i < result.size(); ++i) {
      System.out.printf("%d ", result.get(i));
    }
  }
}

