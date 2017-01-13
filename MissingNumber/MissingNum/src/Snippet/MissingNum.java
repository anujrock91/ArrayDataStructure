package Snippet;

public class MissingNum {
	
	public int getMissingNum(int arr[]){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int xor = 0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] > max){
				max = arr[i];
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}
		for(int i=min;i<=max;i++){
			xor = xor^i;
		}
		for(int i=0;i<arr.length;i++){
			xor = xor^arr[i];
		}
		return xor;
	}
	
	public static void main(String args[]){
		System.out.println(new MissingNum().getMissingNum(new int[]{7,1,3,2,5,6}));
	}
}
