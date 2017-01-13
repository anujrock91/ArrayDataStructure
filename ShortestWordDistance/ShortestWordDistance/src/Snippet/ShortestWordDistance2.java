package Snippet;
import java.util.ArrayList;
import java.util.HashMap;


public class ShortestWordDistance2 {
	private String words[];
	private String word1;
	private String word2;
	private HashMap<String, ArrayList<Integer>> wordsIndex;
	
	public ShortestWordDistance2(String [] words, String word1, String word2){
		this.words = words;
		this.word1 = word1;
		this.word2 = word2;
		wordsIndex = new HashMap<>();
		fillMap();
	}
	
	private void fillMap(){
		for(int i=0;i<words.length;i++){
			if(wordsIndex.containsKey(words[i])){
				wordsIndex.get(words[i]).add(i);
			}
			else{
				wordsIndex.put(words[i], new ArrayList<Integer>());
				wordsIndex.get(words[i]).add(i);
			}
		}
	}
	
	
	public int getShortestDistance(){
		return minDiff(wordsIndex.get(word1), wordsIndex.get(word2));
	}
	
	public int minDiff(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		int firstPointer = 0;
		int secondPointer = 0;
		int min = Integer.MAX_VALUE;
		while(firstPointer < arr1.size() && secondPointer< arr2.size()){
			int diff = Math.abs(arr1.get(firstPointer)-arr2.get(secondPointer));
			if(min > diff){
				min = diff;
			}
			if(arr1.get(firstPointer) >= arr2.get(secondPointer)){
				++secondPointer;
			}
			else{
				++firstPointer;
			}
		}
		return min;
	}
	

}
