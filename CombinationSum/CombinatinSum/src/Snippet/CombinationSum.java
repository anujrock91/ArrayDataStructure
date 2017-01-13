package Snippet;
import java.util.*;

public class CombinationSum {
	
	//Provide a sorted array
	public ArrayList<ArrayList<Integer>> combinationSum(int arr[], int target){
		Arrays.sort(arr);
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		getCombinations(arr, 0, target, temp, result);
		return result;
	}
	
	
	public void getCombinations(int [] arr, int j,int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
		for(int i = j;i<arr.length;i++){
			int current = arr[i];
			if(target-current == 0){
				temp.add(current);
				ArrayList<Integer> newList = new ArrayList<Integer>(temp);
				result.add(newList);
				temp.remove(temp.size()-1);
			}
			else if(target-current > 0){
				temp.add(current);
				getCombinations(arr, i , target-current,temp,result);
				temp.remove(temp.size()-1);
			}
			else{
				break;
			}
		}
	}
	
	
	
	
	
	public static void main(String args[]){
		List<ArrayList<Integer>> l = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
		for(List il: l){
			System.out.println(il);
		}
	}
}
