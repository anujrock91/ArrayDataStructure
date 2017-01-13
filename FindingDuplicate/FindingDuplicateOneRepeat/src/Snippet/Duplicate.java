package Snippet;

public class Duplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDuplicate(new int[]{4,2,1,3,4,4,5}));
	}
	
	public static int getDuplicate(int arr[]){
		int left = 1;
		int right = arr.length-1;
		while(left<right){
			int c = 0;
			int avg = ((left+right)/2);
			for(int x: arr){
				if(x <= avg){
					++c;
				}
			}
			if(c>avg){
				right = avg;
			}
			else{
				left = avg+1;
			}
		}
		return right;
	}
}
