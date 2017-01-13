package Snippet;

public class SearchInRotatedArray {
	
	public int findTargetInRotatedArray(int nums[], int target){
		int minIndex = findMinRotatedArray(nums);
		if(nums[minIndex] <= target && target<=nums[nums.length-1] ){
			return findTarget(nums, minIndex, nums.length-1, target);
		}
		else{
			return findTarget(nums, 0, minIndex-1, target);
		}
	}
	
	//log(n)
	public int findTarget(int nums[], int left, int right, int target){
		int middle = Integer.MIN_VALUE;
		while(left<=right){
			int curr = ((left+right)/2);
			middle = nums[curr];
			if(middle == target){ return curr; }
			else if(middle < target){ left = (curr+1); }
			else{ right = (curr-1); }
		}
		return -1;
	}
	
	//log(n)
	public int findMinRotatedArray(int nums[]){
		int left = 0;
		int right = (nums.length-1);
		while(left < right){
			int current = ((left+right)/2);
			int middle = nums[current];
			if(middle > nums[right]){ left = (current+1); }
			else{ right = current; }
		}
		return left;
	}
	
	public static void main(String args[]){
		System.out.println(new SearchInRotatedArray().findMinRotatedArray(new int[]{11,20,23,1,3,7,9}));
		System.out.println(new SearchInRotatedArray().findTargetInRotatedArray(new int[]{11,20,23,1,3,7,9},7));
	}
}
