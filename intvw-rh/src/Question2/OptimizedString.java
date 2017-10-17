package Question2;

public class OptimizedString {

	/**
	*  Given there are 50000 items in the input String array, the
	*  function must add all array items to outputString and then return
	*  the outputString. if forceUpperCase is true, the return string must be upper case.
	*/
	public String addStringItems(String[] items, boolean forceUpperCase) {
		// Use StringBuffer to concatenate all strings from items array.
		// StringBuffer is more efficient than String and thread safe than StringBuilder  
		StringBuffer returnValue = new StringBuffer();
		for(int i = 0; i < items.length; i++) {
			returnValue.append(items[i]); 
		}
		return forceUpperCase ? returnValue.toString().toUpperCase() : returnValue.toString();
	}
	
	public static void main(String args[]) {
		String[] input = {"Apple", "Banana", "Orange", "Asparagus", "Carrot", "Tomato", "Cherry", "Mellon", "Plum"};
		
		OptimizedString os = new OptimizedString();
		System.out.println(os.addStringItems(input, false));
		System.out.println(os.addStringItems(input, true));
	}
}
