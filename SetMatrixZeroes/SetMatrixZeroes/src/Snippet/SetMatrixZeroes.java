package Snippet;

public class SetMatrixZeroes {
	
	public void setMatrixZeroes(int [][] mat){
		//check for zeroes in first row
		boolean decision1 = false;
		for(int row=1;row<mat[0].length;row++){
			if(mat[0][row] == 0){
				decision1 = true;
			}
		}
		if(decision1){
			for(int row=1;row<mat[0].length;row++){
				if(mat[0][row] == 0){
					mat[0][row] = -1;
				}
				else{
					mat[0][row] = 0;
				}
			}
		}
		
		//check for zeroes in first column
		boolean decision2 = false;
		for(int col=1;col<mat.length;col++){
			if(mat[col][0] == 0){
				decision2 = true;
			}
		}
		if(decision2){
			for(int col=1;col<mat.length;col++){
				if(mat[col][0] == 0){
					mat[col][0] = -1;
				}
				else{
					mat[col][0] = 0;
				}
			}
		}
		
		for(int row = 1;row<mat.length;row++){
			for(int col = 1;col<mat[0].length;col++){
				if(mat[row][col] == 0){
					if(decision1){
						mat[0][col] = -1;
					}
					else{
						mat[0][col] = 0;
					}
					if(decision2){
						mat[row][0] = -1;
					}
					else{
						mat[row][0] = 0;
					}
				}
			}
		}
		
		//Scroll the first row
		for(int col=1;col<mat[0].length;col++){
			if(decision1 && mat[0][col]== -1){
				makeZero(mat, col, 'C');
			}
			else if(!decision1 && mat[0][col] == 0){
				makeZero(mat, col, 'C');
			}
		}
		
		//Scroll the first col
		for(int row=1;row<mat.length;row++){
			if(decision2 && mat[row][0]== -1){
				makeZero(mat, row, 'R');
			}
			else if(!decision2 && mat[row][0] == 0){
				makeZero(mat, row, 'R');
			}
		}
		
		if(mat[0][0] == 0){
			makeZero(mat,0,'R');
			makeZero(mat,0,'C');
		}
		else if(mat[0][0] != 0 && (decision1 || decision2)){
			mat[0][0] = 0;
		}
	}
	
	
	public void makeZero(int [][] mat, int index, char rowOrCol){
		if(rowOrCol == 'R'){
			for(int col=0;col<mat[0].length;col++){
				mat[index][col] = 0;
			}
		}
		else if(rowOrCol == 'C'){
			for(int row=0;row<mat.length;row++){
				mat[row][index] = 0;
			}
		}
	}
	
	
	public static void main(String [] args){
		//int mat[][] = new int[][]{{-1,-1,4,1},{1,1,-1,0},{1,1,2,4},{1,0,5,6}};
		int mat[][] = new int[][]{{-1},{0},{1}};
		new SetMatrixZeroes().setMatrixZeroes(mat);
		for(int arr[]: mat){
			for(int i: arr){
				System.out.print(i + " | ");
			}
			System.out.println();
		}
	}
	
	
}
