package Snippet;
import java.util.HashMap;

public class ContainsDuplicates {
	
	public boolean isDuplicates(int [] nums){
		HashMap<Integer, Integer> elementIndex = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(elementIndex.containsKey(nums[i])){
				return true;
			}
			else{
				elementIndex.put(nums[i], i);
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		System.out.println(new ContainsDuplicates().isDuplicates(new int[]{1,2,3,4}));
	}
}
