package Question4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * PROBLEM SUMMARY:
 * itr1 and itr2 iterate over their contents in sorted order.
 * The result is the combination of itr1 and itr2, in the same order itr1 and itr2 is sorted.
 * The function should operate in O(n) time.
 * 
 * Assumptions:
 * (1) Lists from which itr1 and itr2 contain sorted element in its natural string order.
 * (2) List from which itr1 and itr2 can be of different sizes.
 * (3) the combined list merges both lists and re-sort them in the same manner they were previously sorted. 
 */
public class StringList {
	
	/**
	 * This function uses the available java libraries to sort the combined list. 
	 * 
	 * Example: 
	 * First collection: a, b, c, g, i
	 * Second collection: c, d, h, k
	 * Combined collection: a, b, c, g, i, c, d, h, k
	 */
	public List<String> combine(Iterator<String> itr1, Iterator<String> itr2){
		List<String> combinedList = new ArrayList<String>();
		
		while (itr1.hasNext()) {
			combinedList.add(itr1.next());
		}
		
		while (itr2.hasNext()) {
			combinedList.add(itr2.next());
		}
		
		Collections.sort(combinedList);
		
		return combinedList;
	}
	
	/**
	 * This is a customized function that merge and sort two lists. 
	 * The output of this function should be the same as combine().
	 * 
	 * Time complexity is:
	 * .: at best: O(n) where n is the total number of element in list 1 and 2. 
	 * 		For example: list1 [x, y, z] and list2 [c, b, a].
	 * .: at worst: O(nm) where n is the total number of element in list 1 and m is the total number in list 2. 
	 * 		For example: list1 [a, c, e] and list2 [j, k, l].
	 * .: in average: O(nm).
	 * 
	 * Space complexity is O(n) where n is the total number of element in list 1 and 2.
	 *  
	 * Example: 
	 * First collection: a, b, c, g, i
	 * Second collection: b, g, h, k, m
	 * Combined collection: a, b, b, c, g, g, h, k, m
	 * 
	 * Strategy:
	 * 1. Since both itr1 and itr2 are sorted, I can go ahead add all of them  
	 */
	public List<String> combine2(Iterator<String> itr1, Iterator<String> itr2){
		List<String> sortedList = new ArrayList<String>();
		
		while (itr1.hasNext()) {
			sortedList.add(itr1.next());
		}	
		
		while(itr2.hasNext()) {
			String fromItr2 = itr2.next();
			for (int i=0; i<sortedList.size(); i++) {
				if (fromItr2.compareTo(sortedList.get(i)) <= 0) {
					sortedList = insertElement(sortedList, i, fromItr2);
					break;
				}
				
				if (i == sortedList.size() - 1) {
					sortedList = insertElement(sortedList, sortedList.size(), fromItr2);
					break;
				}
			}
		}
		return sortedList;
	}
	
	private List<String> insertElement(List<String> originalList, int index, String element){
		List<String> resizedList = new ArrayList<String>(originalList.size()	+ 1);
		// base case 1: if insertion at the head
		if (index == 0) {
			resizedList.add(element);
			resizedList.addAll(1, originalList);
			return resizedList;
		}
		// base case 2: if insertion at the end
		if (index == originalList.size()) {
			resizedList.addAll(originalList);
			resizedList.add(index, element);
			return resizedList;
		}
			
		// otherwise, insertion in the middle
		List<String> headList = originalList.subList(0, index);
		resizedList.addAll(headList);
		resizedList.add(element);
		List<String> tailList = originalList.subList(index, originalList.size());
		resizedList.addAll(tailList);
		
		return resizedList;
	}
	
	public static void main(String args[]) {
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("g");
		list1.add("i");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("a");
		list2.add("c");
		list2.add("d");
		list2.add("h");
		list2.add("k");
		
		StringList sl = new StringList();
		System.out.println(sl.combine(list1.iterator(), list2.iterator()));
		System.out.println(sl.combine2(list1.iterator(), list2.iterator()));
		
	}
}
