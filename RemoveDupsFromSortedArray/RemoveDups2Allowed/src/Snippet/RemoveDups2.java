package Snippet;

public class RemoveDups2 {
	
	public int remove(int nums[]){
		int left = 0;
		int right = 1;
		int count =1;
		while(left < nums.length && right < nums.length){
			if(nums[left] == nums[right] && count<2){
				++count;
				++left;
				nums[left] = nums[right];
				++right;
			}
			else if(nums[left] == nums[right] && count>=2){
				++right;
			}
			else{
				count = 1;
				++left;
				nums[left] = nums[right];
				++right;
			}
		}
		return left;
	}
	

	public static void main(String args[]){
		int nums[] = new int[]{1,1,1,1,2,2,2,2,3,4,4,4,5,5,6,6,6,6,7,8,9,9,9,10};
		int index = new RemoveDups2().remove(nums);
		for(int i=0;i<=index;i++){
			System.out.print(nums[i] + " | ");
		}
		System.out.println();
	}
}
