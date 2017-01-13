package Snippet;
import java.util.Stack;

public class TrappingRainWater {
	
	public int trap(int[] height){
		Stack<Integer> leftToRightMax = new Stack<>();
		Stack<Integer> rightToLeftMax = new Stack<>();
		
		//Scanning left to right
		for(int i=0;i<height.length;i++){
			if(leftToRightMax.isEmpty()){ leftToRightMax.push(i); }
			else if(height[leftToRightMax.peek()] < height[i]){ leftToRightMax.push(i); }
		}
		 
		//Scanning from right to left
		for(int i=height.length-1;i>=0;i--){
			if(rightToLeftMax.isEmpty()){ rightToLeftMax.push(i); }
			else if(height[rightToLeftMax.peek()] < height[i]){ rightToLeftMax.push(i); }
		}
		
		int sum = 0;
		if(leftToRightMax.peek() != rightToLeftMax.peek()){
			int leftIndex = leftToRightMax.peek();
			int rightIndex = rightToLeftMax.peek();
			int area = ((rightIndex-leftIndex-1)*height[leftIndex]);
			for(int i=leftIndex+1;i<rightIndex;i++){
				area -= height[i];
			}
			sum += area;
		}
		
		while(leftToRightMax.size() != 1){
			int currentMax = leftToRightMax.pop();
			int prevMax = leftToRightMax.peek();
			int area = ((currentMax-prevMax-1)*height[prevMax]);
			for(int i=currentMax-1;i>prevMax;i--){
				area -= height[i];
			}
			sum += area;
		}
		
		while(rightToLeftMax.size() != 1){
			int currentMax = rightToLeftMax.pop();
			int nextMax = rightToLeftMax.peek();
			int area = ((nextMax-currentMax-1)*height[nextMax]);
			for(int i=currentMax+1;i<nextMax;i++){
				area -= height[i];
			}
			sum += area;
		}
		return sum;
	}
	
	
	public static void main(String [] args){
		System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,1,0}));
	}
}
