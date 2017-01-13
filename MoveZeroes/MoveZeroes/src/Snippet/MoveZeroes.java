package Snippet;

public class MoveZeroes {
	
	public int [] getNums(int arr[]){
		int left = 0;
		int right = 0;
		while(left<arr.length && right<arr.length){
			while(left<arr.length && arr[left] != 0){ ++left; }
			while(right<arr.length && arr[right] == 0){ ++right; }
			if(left < arr.length && right<arr.length){
				arr[left] = arr[right];
				arr[right] = 0;
			}
		}
		return arr;
	}
	
	public static void main(String args[]){
		int arrtemp[] = new MoveZeroes().getNums(new int[]{0,10,3,12,4,0,4,00,0,0,5,2});
		for(int element: arrtemp){
			System.out.print(element + " | ");
		}
		System.out.println();
	}
}
