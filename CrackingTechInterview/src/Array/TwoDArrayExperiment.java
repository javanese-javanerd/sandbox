package Array;

public class TwoDArrayExperiment {
	public static void main(String args[]) {
		String[][] myArray = {
				{"00", "10", "20", "30"},
				{"01", "11", "21", "31"},
				{"02", "12", "22", "32"},
				{"03", "13", "23", "33"}
		};
		
		for (int v=0; v<myArray.length; v++) {
			for (int h=0; h<myArray[v].length; h++) {
				System.out.print(myArray[v][h] + " ");
			}
			System.out.println();
		}
		
		System.out.println("****************");
		
		for (int v=0; v<myArray.length; v++) {
			for (int h=0; h<myArray[v].length; h++) {
				System.out.print(myArray[h][v] + " ");
			}
			System.out.println();
		}
	}
}
