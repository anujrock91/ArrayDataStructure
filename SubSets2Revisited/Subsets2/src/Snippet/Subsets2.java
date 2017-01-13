package Snippet;
import java.util.*;

public class Subsets2 {
	
	public ArrayList<ArrayList<Integer>> subsets2(int [] nums){
		Arrays.sort(nums);
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		getSubsets(nums, 0, temp, result);
		return result;
	}
 	
	public void getSubsets(int nums[], int j, ArrayList<Integer>temp, ArrayList<ArrayList<Integer>>result ){
		if(j<nums.length){
			temp.add(nums[j]);
			ArrayList<Integer> newList = new ArrayList<>(temp);
			result.add(newList);
			getSubsets(nums, j+1, temp, result);
			temp.remove(temp.size()-1);
		}
		for(int i=j+1;i<nums.length;i++){
			if(nums[i-1] != nums[i]){
				temp.add(nums[i]);
				ArrayList<Integer> newList1 = new ArrayList<>(temp);
				result.add(newList1);
				getSubsets(nums, i+1, temp, result);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String args[]){
		List<ArrayList<Integer>> l = new Subsets2().subsets2(new int[]{1,2,2,3});
		for(List<Integer> il: l){ System.out.println(il); }
	}
	
	
}
