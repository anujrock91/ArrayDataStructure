package Snippet;

public class SortColors {
	
	
	public void SortColors(int nums[]){
		int low = 0;
		int mid = 0;
		int high = nums.length-1;
		while(mid<=high){
			if(nums[mid] == 0){ 
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;++low;++mid;
			}
			else if(nums[mid] == 1){
				++mid;
			}
			else{
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				--high;
			}
		}
		
		for(int i: nums){ System.out.print( i + " | ");} 
		System.out.println();
	}
	
	
	
	public static void main(String args[]){
		new SortColors().SortColors(new int[]{1,2,0,0,2,1,0,1,2,2,1,0,1,0,0});
	}
}
