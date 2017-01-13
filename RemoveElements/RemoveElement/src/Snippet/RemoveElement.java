package Snippet;

public class RemoveElement {
	
	public int removeElement(int []nums, int val){
		return partition(nums, 0, nums.length-1, val);
	}
	
	public int partition(int [] nums, int left, int right, int pivot){
		while(left <= right){
			while(nums[left] != pivot){ ++left; }
			while(nums[right] == pivot){ --right; }
			if(left<=right){
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
				++left;
				--right;
			}
		}
		return left;
	}
	
	public static void main(String []args){
		int nums[] = new int[]{3,2,2,3};
		int index = new RemoveElement().removeElement(nums, 3);
		for(int i=0;i<index;i++){
			System.out.println(nums[i]);
		}
	}
}
