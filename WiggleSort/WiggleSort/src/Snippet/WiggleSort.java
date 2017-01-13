package Snippet;

public class WiggleSort {
	
	public void wiggleSort(int [] nums){
		if(nums.length == 1 || nums.length == 0){return;}
		else{
			int i=0;
			for(i=1;i<nums.length-1;i=i+2){
				swapMax(nums, i, 3);
			}
			if(i==(nums.length-1)){ swapMax(nums, i, 2);}
			else{return;}
		}
	}
	
	private void swapMax(int [] nums, int index, int numberOfElements){
		int current = nums[index];
		int prev = nums[index-1];
		if(numberOfElements == 3){
			int next = nums[index+1];
			int max = Math.max(current, prev);
			max = Math.max(max, next);
			if(max!=current && max==next){nums[index+1] = current; nums[index] = next;}
			else if(max!=current && max==prev){nums[index] = prev; nums[index-1] = current;}
		}
		else{
			int max = Math.max(current, prev);
			if(max!=current && max==prev){nums[index] = prev; nums[index-1] = current;}
		}
	}
	
	public static void main(String args[]){
		int [] nums= new int[]{3, 5, 2, 1, 6, 4};
		new WiggleSort().wiggleSort(nums);
		for(int i: nums){System.out.print( i+" | ");}
		System.out.println();
	}
	
}
