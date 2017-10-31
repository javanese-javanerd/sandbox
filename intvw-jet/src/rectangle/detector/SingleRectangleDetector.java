package rectangle.detector;

/**
 * The image you get is known to have N rectangles of 0s on a background of 1s.
 * Write a function that takes in the image and outputs the coordinates of all
 * the 0 rectangles in either of these format: .: top-left and bottom-right; .:
 * top-left, width and height.
 * 
 * @author javanese-javanerd
 */
public class SingleRectangleDetector {

	/**
	 * Time complexity: O(wh) 
	 * 	.: w = width of image
	 * 	.: h = height of image
	 *  
	 * Space complexity: O(1)
	 * @param image
	 * @return
	 */
	public static Rectangle findRectangle(int[][] image) {
		Rectangle rect = new Rectangle();
		
		for (int v = 0; v < image.length; v++) {
			for (int h = 0; h < image[v].length; h++) {
				System.out.print(image[v][h] +  " ");
				if (0 == image[v][h]) {
					// we found a rectangle
					if (rect.xCoordinate == -1 && rect.yCoordinate == -1) {
						rect.xCoordinate = h;
						rect.yCoordinate = v;
					}
					if (h == rect.xCoordinate)
						rect.height++;
					if (v == rect.yCoordinate)
						rect.width++;
				}
			}
			System.out.println();
		}

		return rect;
	}

	public static void main(String[] args) {
		int[][] image1 = {
				{ 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 0, 1 } };
		Rectangle rectangle = findRectangle(image1);
		System.out.println("Top left coordinate: " + rectangle.xCoordinate + "," + rectangle.yCoordinate);
		System.out.println("Width of rectangle: " + rectangle.width);
		System.out.println("Height of rectangle: " + rectangle.height);
		System.out.println("*********************");

		int[][] image2 = { 
				{ 0, 0, 0, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 0, 1 } };
		rectangle = findRectangle(image2);
		System.out.println("Top left coordinate: " + rectangle.xCoordinate + "," + rectangle.yCoordinate);
		System.out.println("Width of rectangle: " + rectangle.width);
		System.out.println("Height of rectangle: " + rectangle.height);
		System.out.println("*********************");
		
		int[][] image3 = { 
				{ 0, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 0, 1 } };
		rectangle = findRectangle(image3);
		System.out.println("Top left coordinate: " + rectangle.xCoordinate + "," + rectangle.yCoordinate);
		System.out.println("Width of rectangle: " + rectangle.width);
		System.out.println("Height of rectangle: " + rectangle.height);
		System.out.println("*********************");
		
		int[][] image4 = { 
				{ 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 0 } };
		rectangle = findRectangle(image4);
		System.out.println("Top left coordinate: " + rectangle.xCoordinate + "," + rectangle.yCoordinate);
		System.out.println("Width of rectangle: " + rectangle.width);
		System.out.println("Height of rectangle: " + rectangle.height);
		System.out.println("*********************");
		
		int[][] image5 = { 
				{ 1, 1, 0, 1, 1, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1 } };
		rectangle = findRectangle(image5);
		System.out.println("Top left coordinate: " + rectangle.xCoordinate + "," + rectangle.yCoordinate);
		System.out.println("Width of rectangle: " + rectangle.width);
		System.out.println("Height of rectangle: " + rectangle.height);
		System.out.println("*********************");
	}

	static class Rectangle {
		int width = 0;
		int height = 0;
		int xCoordinate = -1;
		int yCoordinate = -1;
	}
}
