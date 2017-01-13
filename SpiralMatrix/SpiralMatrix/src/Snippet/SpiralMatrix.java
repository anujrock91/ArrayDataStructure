package Snippet;
import java.util.*;

public class SpiralMatrix {
	
	public List<Integer> spiralMatrix(int [][] mat){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int rows = mat.length;
		int cols = mat[0].length;
		int loop = Math.max((cols/2),((rows/2)));
		int index = 0;
		int rowIndex = 0;
		int colIndex = 0;
		while(index < loop){
			
			//Sweeping through top row
			for(int i=colIndex;i<cols-colIndex;i++){
				temp.add(mat[rowIndex][i]);
			}
			temp.remove(temp.size()-1);
			
			//Sweeping through right column
			for(int i=rowIndex;i<rows-rowIndex;i++){
				temp.add(mat[i][cols-colIndex-1]);
			}
			temp.remove(temp.size()-1);
			
			//Sweeping through last row
			for(int i=cols-colIndex-1;i>=colIndex;i--){
				temp.add(mat[rows-rowIndex-1][i]);
			}
			temp.remove(temp.size()-1);
			
			//Sweeping through left column
			for(int i=rows-rowIndex-1;i>=rowIndex;i--){
				temp.add(mat[i][colIndex]);
			}
			temp.remove(temp.size()-1);
			++rowIndex;
			++colIndex;
			++index;
		}
		
		if((rows%2)!=0 && (cols%2)!=0){
			temp.add(mat[rowIndex][colIndex]);
		}
		
		return temp;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = new int[][]{{1,2,3},{5,6,7},{9,10,11},{13,14,15}};
		List<Integer> l = new SpiralMatrix().spiralMatrix(mat);
		System.out.println(l);
	}

}
