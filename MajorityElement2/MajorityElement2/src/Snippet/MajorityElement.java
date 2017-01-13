package Snippet;
import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

	public List<Integer> getMajorityElements(int nums[]){
		int count1 = 0;
		int count2 = 0;
		int result1 = 0;
		int result2 = 0;
		
		for(int i=0;i<nums.length;i++){
			if(count1 == 0){
				result1 = nums[i];
				count1 = 1;
			}
			else if(count2 == 0){
				result2 = nums[i];
				count2 = 1;
			}
			else if(count1 != 0 && result1 == nums[i]){
				++count1;
			}
			else if(count2 != 0 && result2 == nums[i]){
				++count2;
			}
			else{
				--count1;
				--count2;
			}
		}
		
		count1 = 0;
		count2 = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i] == result1){ ++count1; }
			if(nums[i] == result2){ ++count2; }
		}
		ArrayList<Integer> result = new ArrayList<>();
		if(count1 > (nums.length/3)){ result.add(result1); }
		if(count2 > (nums.length/3)){ result.add(result2); }
		return result;
	}
	 
	
	
	public static void main(String[] args) {
		List<Integer> l = new MajorityElement().getMajorityElements(new int[]{1,3,1,2,2});
		for(Integer i : l){System.out.print(i+" | ");}
		System.out.println();
	}
	
	

}
