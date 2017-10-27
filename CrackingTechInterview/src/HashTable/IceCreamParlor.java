package HashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together M dollars for ice cream. 
On any given day, the parlor offers a line of N flavors. 
Each flavor, i, is numbered sequentially with a unique ID number from 1 to N and has a cost, cost-i, associated with it.

Given the value of M and the cost of each flavor for t trips to the Ice Cream Parlor, help Sunny and Johnny choose two distinct flavors 
such that they spend their entire pool of money during each visit. For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

Note: Two ice creams having unique IDs i and j may have the same cost.

Input Format

The first line contains an integer, t, denoting the number of trips to the ice cream parlor. 
The 3t subsequent lines describe all of Sunny and Johnny's trips to the parlor; each trip is described as follows:

The first line contains money M.
The second line contains N.
The third line contains n space-separated integers denoting the cost of each respective flavor. 
	The i-th integer corresponds to the cost, cost-i, for the ice cream with ID number i (where 1 < i < n).

Constraints
	.: 1 <= t <= 50
	.: 2 <= money <= 10^4
	.: 2 <= n <= 10^4
	.: 1 <= cost-i <= 10^4 (where i E[1,n]) 
	.: It is guaranteed that there will always be a unique solution.

Output Format

Print two space-separated integers denoting the respective ID numbers for the two distinct flavors they choose to purchase, where the smaller ID is printed first and the larger ID is printed second. 
Recall that each ice cream flavor has a unique ID number in the inclusive range from 1 to flavors.

Sample Input
	2
	4
	5
	1 4 5 3 2
	4
	4
	2 2 4 3

Sample Output
	1 4
	1 2

Explanation

Sunny and Johnny make the following two trips to the parlor:

The first time, they pool together m=4 dollars. There are five flavors available that day and flavors 1 and 4 have a total cost of 4. Thus, we print 1 4 on a new line.
The second time, they pool together m=4 dollars. There are four flavors available that day and flavors 1 and 2 have a total cost of 4. Thus, we print 1 2 on a new line.


 * @author javanese-javanerd
 *
 */
public class IceCreamParlor {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            
            findIceCreamFlavors(a, m);
        }
    }
    
	/**
	 * Runtime complexity: O(n) where n is the number of elements in array A.
	 * Space complexity: O(n) as we may need to insert almost, if not all, of the elements in array A into a hashmap.
	 * 
	 * @param a
	 * @param m
	 */
    public static void findIceCreamFlavors(int[] a, int m){
        Map<Integer, Integer> complements = new HashMap<Integer, Integer>();
        for (int index=0; index<a.length; index++){
            int compl = m-a[index];
            if (complements.containsKey(compl)){
                if (index+1 < complements.get(compl)) {
                    System.out.println(index+1 + " " + complements.get(compl));
                    return;
                }
                else {
                    System.out.println(complements.get(compl) + " " + (index+1));
                    return;
                }
            }
            else {
                complements.put(a[index], index+1);
            }
        }
    }

}
