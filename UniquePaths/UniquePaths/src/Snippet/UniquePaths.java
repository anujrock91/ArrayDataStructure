package Snippet;

public class UniquePaths {
	
	
	public int uniquePaths(int m, int n){
		int [][] mat = new int [m+1][n+1];
		mat[1][1] = 2;
		for(int row=1;row<m+1;row++){
			for(int col=1;col<n+1;col++){
				if(row == m){
					mat[row][col] = (mat[row][col-1]+(mat[row-1][col]/2));
				}
				else if(col == n){
					mat[row][col] = ((mat[row-1][col])+((mat[row][col-1])/2));
				}
				else{
					mat[row][col] = (2*(mat[row-1][col]/2))+(2*(mat[row][col-1]/2)+(mat[row][col]));
				}
				if(row == m && col==n){
					mat[row][col] = (mat[row-1][col]+mat[row][col-1]);
				}
			}
		}
		return mat[mat.length-1][mat[0].length-1];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniquePaths().uniquePaths(30, 70));
	}

}
