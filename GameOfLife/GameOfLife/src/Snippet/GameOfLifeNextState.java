package Snippet;

public class GameOfLifeNextState {
	
	public static void getNextState(int mat[][]){
		int numRows = mat.length;
		int numCol = mat[0].length;
		if(mat.length < 3 && mat[0].length < 3){
			return;
		}
		else{
			int row;
			int column;
			for(row=1;row < mat.length;row++){
				for(column=1;column < mat[0].length; column++){
					int start = row-1;
					int end = column-1;
					int count = 0;
					while((start < row+2)){
						while((end< column+2)){
							if(start == row && column == end){
								++end;
							}
							else{
								int andResult = (mat[start%numRows][end%numCol]&1);
								if(andResult == 1){++count;}
								++end;
							}
						}
						end = column-1;
						++start;
					}
					
					//<2 cell dies
					if(count < 2){
						mat[row][column] = (mat[row][column]&1);
					}
					
					//2 , 3 maintains state
					if(count == 2 || count == 3){
						mat[row][column] = (mat[row][column] | (mat[row][column]<<1));
					}
					
					if(count > 3){
						mat[row][column] = (mat[row][column]&1);
					}
					
					if(count == 3 && (mat[row][column]&1) == 0){
						mat[row][column] = (mat[row][column] | 1<<1);
					}
					
					
				}//end of column for loop
			}//end of row for loop
			
			
			//for 0 row 
			for(int col = 0; col< numCol;col++){
				int start = (-1);
				int end = (col - 1);
				int count = 0;
				while(start < 2){
					while(end < (col+2)){
						if(start == 0 && end == col){
							++end;
						}
						else{
							int andRes = 0;
							if(start < 0 && end < 0){
								andRes = (mat[(numRows - start)%numRows][(numCol - end)%numCol]&1);
							}
							else if(start < 0){
								andRes = (mat[(numRows - start)%numRows][end%numCol]&1);
							}
							else if(col < 0){
								andRes = (mat[(start)%numRows][(numCol - end)%numCol]&1);
							}
							else{
								andRes = (mat[(start)%numRows][(numCol)%numCol]&1);
							}
							if(andRes == 1){
								++count;
							}
						}
						++end;
					}
					end  = (col-1);
					++start;
				}
				//<2 cell dies
				if(count < 2){
					mat[0][col] = (mat[0][col]&1);
				}
				
				//2 , 3 maintains state
				else if(count == 2 || count == 3){
					mat[0][col] = (mat[0][col] | (mat[0][col]<<1));
				}
				
				else if(count > 3){
					mat[0][col] = (mat[0][col]&1);
				}
				
				else if(count == 3 && (mat[0][col]&1) == 0){
					mat[0][col] = (mat[0][col] | 1<<1);
				}
			}
			
			
			//Converting to final output
			for(int r = 0;r<numRows;r++){
				for(int col = 1;col<numCol;col++){
					mat[r][col] = (mat[r][col]>>1);
				}
			}
			
		}// end of main else
	}//end of function
	
}
