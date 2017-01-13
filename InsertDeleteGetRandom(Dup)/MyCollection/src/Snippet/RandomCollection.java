package Snippet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

public class RandomCollection {
	private HashMap<Integer, ArrayList<Integer>> valueCount;
	private HashMap<Integer, Integer> indexValue;
	private static int counter = 0;

	public RandomCollection(){
		valueCount = new HashMap<>();
		indexValue = new HashMap<>();
	}
	
	//O(1)
	public boolean insert(int value){
		++counter;
		if(valueCount.containsKey(value)){
			ArrayList<Integer> existingList = valueCount.get(value);
			existingList.add(counter);
		}
		else{
			ArrayList<Integer> newList = new ArrayList<>();
			newList.add(counter);
			valueCount.put(value,newList);
		}
		indexValue.put(counter, value);
		return true;
	}
	
	
	//O(1)
	public boolean remove(int value){
		if(!valueCount.containsKey(value)){
			return false;
		}
		else if(indexValue.size() == 1){
			--counter;
			valueCount = new HashMap<>();
			indexValue = new HashMap<>();
			return true;
		}
		else if(indexValue.get(counter) == value){
			indexValue.remove(counter);
			--counter;
			ArrayList<Integer> existingList = valueCount.get(value);
			existingList.remove(existingList.size()-1);
			if(existingList.isEmpty()){
				valueCount.remove(value);
			}
			return true;
		}
		else{
			ArrayList<Integer> existingList = valueCount.get(value);
			int index = existingList.get(existingList.size()-1);
			existingList.remove(existingList.size()-1);
			if(existingList.isEmpty()){
				valueCount.remove(value);
			}
			int itemLastInserted = indexValue.remove(counter);
			--counter;
			ArrayList<Integer> listLastInserted = valueCount.get(itemLastInserted);
			listLastInserted.remove(listLastInserted.size()-1);
			listLastInserted.add(index);
			indexValue.put(index, itemLastInserted);
			return true;
		}
	}
	
	public Integer getRandom(){
		if(indexValue.isEmpty()){return null;}
		Random number = new Random();
		int randomNumber=number.nextInt(counter+1);
		while(randomNumber == 0){
			randomNumber = number.nextInt(counter+1);
		}
		return indexValue.get(randomNumber);
	}
	
	
	public void displayCollection(){
		for(Entry<Integer, Integer> e : indexValue.entrySet()){
			System.out.print("index"+e.getKey() + "=" + e.getValue() + " || ");
		}
		System.out.println();
	}
	
}
