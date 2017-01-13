package Snippet;
import java.util.*;

public class Triangle {
	
	 public int minimumTotal(List<List<Integer>> triangle) {
		 return minimumTotal(triangle, 0, 0);
	 }
	 
	 private int minimumTotal(List<List<Integer>> triangle, int level, int childIndex){
		 if(level == triangle.size()-1){
			 return triangle.get(level).get(childIndex);
		 }
		 else{
			 int nodeValue = triangle.get(level).get(childIndex);
			 int leftValue = minimumTotal(triangle, level+1, childIndex);
			 int rightValue = minimumTotal(triangle, level+1, childIndex+1);
			 return Math.min(leftValue+nodeValue, rightValue+nodeValue);
 		 }
	 }
	 
	 public static void main(String [] args){
		 ArrayList<Integer> temp1 = new ArrayList<Integer>(); temp1.add(4);
		 ArrayList<Integer> temp2 = new ArrayList<Integer>(); temp2.add(3); temp2.add(2);
		 ArrayList<Integer> temp3 = new ArrayList<Integer>(); temp3.add(1); temp3.add(1);temp3.add(8); 
		 ArrayList<Integer> temp4 = new ArrayList<Integer>();temp4.add(4); temp4.add(7);temp4.add(6); temp4.add(5);
		 ArrayList<List<Integer>> triangle = new ArrayList<>();
		 triangle.add(temp1);triangle.add(temp2);triangle.add(temp3);triangle.add(temp4);
		 System.out.println(new Triangle().minimumTotal(triangle));
	 }
}
