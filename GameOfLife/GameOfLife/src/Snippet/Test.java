package Snippet;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = new int[][]{{0,1,0,1,0},{1,1,1,0,0},{0,0,0,1,0},{1,0,1,1,0},{0,1,0,0,0}};
		GameOfLifeNextState.getNextState(mat);
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}

}
