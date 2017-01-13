package Snippet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;

public class CombinationSum3 {
	
	public List<List<Integer>> combinationSum3(int k, int n){
		ArrayList<List<Integer>> result = new ArrayList<>();
		LinkedHashSet<Integer> temp = new LinkedHashSet<Integer>();
		combinationSum3(k, n, 1, 0, result, temp);
		result = (ArrayList<List<Integer>>) filterResult(result);
		return result;
	}
	
	public void combinationSum3(int k, int n, int current, int sum, ArrayList<List<Integer>> result, LinkedHashSet<Integer> temp){
		if(current == k){
			for(int i=1;i<10;i++){
				if(!temp.contains(i) && sum+i == n){
					//Add in result set
					temp.add(i);
					ArrayList<Integer> newList = new ArrayList<>(temp);
					result.add(newList);
					temp.remove(i);
				}
			}
			return;
		}
		else{
			for(int i=1;i<10;i++){
				if(!temp.contains(i)){
					temp.add(i);
					sum = sum+i;
					combinationSum3(k, n, current+1, sum, result, temp);
					sum -= i;
					temp.remove(i);
				}
			}
		}
	}
	
	public List<List<Integer>> filterResult(List<List<Integer>> result){
		HashMap<String, List<Integer>> pattern = new HashMap();
		for(List<Integer> temp: result){
			int [] signature = new int[10];
			for(Integer i: temp){
				signature[i] = 1;
			}
			String r="";
			for(int x=0;x<signature.length;x++){
				r = r+signature[x];
			}
			if(pattern.containsKey(r)){}
			else{
				pattern.put(r, temp);
			}
		}
		result = new ArrayList<List<Integer>>();
		for(Entry<String, List<Integer>> e: pattern.entrySet()){
			result.add(e.getValue());
		}
		return result;
	}
	
	public static void main(String [] args){
		List<List<Integer>> l = new CombinationSum3().combinationSum3(3, 9);
		for(List<Integer> x: l){
			System.out.println(x);
		}
	}
	
}
