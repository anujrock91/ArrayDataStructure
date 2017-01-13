package Snippet;
import java.util.*;

public class PascalTriangle2 {
	
	public List<Integer> getKthRow(int rowNum){
		return getKthRow(rowNum, rowNum+1);
	}
	
	public List<Integer> getKthRow(int rowNum,int level){
		if(level <= 0){ return null; }
		if(level == 1){ 
			ArrayList<Integer> temp = new ArrayList<Integer>(); 
			temp.add(1);
			return temp; 
		}
		else if(level == 2){
			ArrayList<Integer> temp = new ArrayList<Integer>(); 
			temp.add(1);
			temp.add(1);
			return temp;
		}
		else{
			List<Integer> temp = getKthRow(rowNum, level-1);
			for(int i=(temp.size()-2);i>=0;i--){
				int a = temp.get(i);
				int b = temp.get(i+1);
				temp.add(i+1, a+b);
				temp.remove(i+2);
			}
			temp.add(1);
			return temp;
		}
	}
	
	public static void main(String args[]){
		List<Integer> l = new PascalTriangle2().getKthRow(5);
		System.out.println(l); 
	}
	
}
