package Snippet;

public class InsertPosition {
	
	public int insertIndex(int nums[], int target){
		int left = 0;
		int right = nums.length-1;
		int middle = 0;
		while(left <= right){
			middle = ((left+right)/2);
			int current = nums[middle];
			if(target > current){ left = (middle+1); }
			else if(target < current){ right = (middle-1); }
			else{
				return middle;
			}
		}
		if(nums[middle] < target){ return middle+1; }
		else if(nums[middle] > target){ return middle; }
		return 0;
	}
	
	public static void main(String args[]){
		System.out.println(new InsertPosition().insertIndex(new int[]{1,3,5,6}, 2));
	}
}
