package Snippet;

public class UniquePaths2 {
	
	public int uniquePaths2(int[][] obstacleGrid){
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int [][]mat = new int[m+1][n+1];
		
		if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) 
	        return 0;
		//Copying the mat
		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){
				mat[i][j] = obstacleGrid[i-1][j-1];
			}
		}
		
		//Finding the first non zero element and inserting 2
		int i,j=1,flag=0;
		for(i=1;i<m+1;i++){
			for(j=1;j<n+1;j++){
				if(mat[i][j] != 1){
					flag = 1;
					break;
				}
			}
			if(flag == 1){ break; }
		}
		mat[i][j] = 2;
		
		for(int row=1;row<m+1;row++){
			for(int col=1;col<n+1;col++){
				if(col == n){
					if(mat[row][col] == 1){
						mat[row][col] = 0;
					}
					else{ mat[row][col] = (mat[row-1][col]+(mat[row][col-1]/2)); }
					
				}
				else if(row == m){
					if(mat[row][col] == 1){
						mat[row][col] = 0;
					}
					else{ mat[row][col] = ((mat[row-1][col]/2)+mat[row][col-1]);	}
				}
				else if(mat[row][col] == 1){
					mat[row][col] = 0;
				}
				else{
					mat[row][col] += ((2*(mat[row-1][col]/2))+(2*(mat[row][col-1]/2)));
				}
				if(row==m && col==n){
					mat[row][col] = (mat[row][col-1] + mat[row-1][col]);
				}
			}
		}
		return mat[m][n];
	}

	
	
	
	public static void main(String [] args){
		System.out.println(new UniquePaths2().uniquePaths2(new int[][]{{0,1,0},{0,0,0},{0,0,0}}));
	}
}
