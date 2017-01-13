package Snippet;
import java.util.ArrayList;

public class SumSmaller3 {
	
	public int get3SumSmaller(int [] arr, int target){
		int count = 0;
		sort(arr, 0, arr.length-1);
		for(int i=0;i<(arr.length-2);i++){
			int a = arr[i];
			int left = i+1;
			int right = (arr.length-1);
			while(left<right){
				int b = arr[left];
				int c = arr[right];
				int sum = (a+b+c);
				if(sum <= target){++count;}
				--right;
			}
		}
		return count;
	}
	
	public static void sort(int arr[], int left, int right){
		if(left == right){}
		else{
			int partitionIndex = partition(arr, left, right);
			if(left < partitionIndex-1){ sort(arr, left, partitionIndex-1); }
			if(right > partitionIndex ){ sort(arr, partitionIndex, right); }
		}
	}
	
	public static int partition(int arr[], int left, int right){
		int p = arr[(left+right)/2];
		while(left<=right){
			while(left<=right && arr[left] < p){ ++left; }
			while(left<=right && arr[right] > p){ --right; }
			if(left<=right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				++left;
				--right;
			}
		}
		return left;
	}
	
	
	public static void main(String args[]){
		int arr[] = new int[]{-2,0,1,1,2,2,4,5,8};
		System.out.println(new SumSmaller3().get3SumSmaller(arr, 2));
	}
}
