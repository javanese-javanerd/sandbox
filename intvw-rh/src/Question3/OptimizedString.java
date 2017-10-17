package Question3;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OptimizedString {

	/**
	*  Given there are 50000 items in the input String array, the
	*  function must add all array items to outputString and then return
	*  the outputString. if forceUpperCase is true, the return string must be upper case.
	*/
	public String addStringItems(String[] items, boolean forceUpperCase) {
		// (1) Using a list implementation because order and uniqueness of the items do not matter.
		// (2) The optimized function from Question 2 is thread safe because it uses StringBuffer to store the concatenated string.
		// (3) With the exception of Vector and HashMap, all other Collection implementations in Java is not thread safe. 
		// (4) There are two ways to make Collection implementations a thread safe:
		//		a. Leverage the Collections utility class’ factory methods. In the case of a list, we can use this:
		//			Collections.synchronizedList(new ArrayList<String>());
		// 		b. Use concurrent collections. In the case of a list, we can use CopyOnWriteArrayList
		List<String> itemsList = new CopyOnWriteArrayList<String>();
		for(int i = 0; i < items.length; i++) {
				itemsList.add(items[i]);
		}
		
		StringBuffer concatenatedItems = new StringBuffer();
		for (String item : itemsList) {
			if (forceUpperCase) {
				concatenatedItems.append(item.toUpperCase());
			}
			else {
				concatenatedItems.append(item);
			}
		}
		
		return concatenatedItems.toString();
	}
	
	public static void main(String args[]) {
		String[] input = {"Apple", "Banana", "Orange", "Asparagus", "Carrot", "Tomato", "Cherry", "Mellon", "Plum"};
		
		OptimizedString os = new OptimizedString();
		System.out.println(os.addStringItems(input, false));
		System.out.println(os.addStringItems(input, true));
	}
}
