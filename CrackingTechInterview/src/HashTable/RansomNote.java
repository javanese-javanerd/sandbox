package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 * 
 * Assumption:
 * 1. array won't be null or empty
 * 2. array contain strings
 * 
 * This solution has a linear complexity.
 * Runtime complexity: O(m) where m is the size of magazine array.
 * Space complexity: O(hm) where hm is the size of hashed-magazine map.
 * 
 * @author javanese-javanerd
 */
public class RansomNote {

	public static String canCreateRansomNote(String[] magazine, String[] ransomWords){
        Map<String, Integer> hashedMagazine = hashify(magazine);
        for (String ransomWord : ransomWords){
            if (null != hashedMagazine.get(ransomWord)){
                int count = hashedMagazine.get(ransomWord);
                if (count > 0){
                    hashedMagazine.put(ransomWord, --count);
                }
                else {
                    return "No";
                }
            }
            else {
            		return "No";
            }
        }
        
        return "Yes";
    }
    
    private static Map<String, Integer> hashify(String[] magazine){
        Map<String, Integer> hashedMagazine = new HashMap<String, Integer>();
        for (String word : magazine){
            if (null != hashedMagazine.get(word)){
                int count = hashedMagazine.get(word);
                hashedMagazine.put(word, ++count);
            }
            else {
                hashedMagazine.put(word, 1);
            }
        }
        
        return hashedMagazine;
    }
    
    public static void main(String args[]) {
    		String[] magazine = {"give", "me", "one", "grand", "today", "night", "me"};
    		String[] ransom = {"give", "one", "grand", "today"};
    		System.out.println(canCreateRansomNote(magazine, ransom));
    		
    		String[] magazine2 = {"two", "times", "three", "is", "not", "four"};
    		String[] ransom2 = {"two", "times", "two", "is", "four"};
    		System.out.println(canCreateRansomNote(magazine2, ransom2));
    }
}
