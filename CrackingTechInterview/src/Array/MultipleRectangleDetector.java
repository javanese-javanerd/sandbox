package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * The image you get is known to have N rectangles of 0s on a background of 1s. 
 * Write a function that takes in the image and outputs the coordinates of all the 0 rectangles in either of these format:
 * .: top-left and bottom-right; 
 * .: top-left, width and height.
 * 
 * @author javanese-javanerd
 */
public class MultipleRectangleDetector {
	  
	public static List<Rectangle> findRectangle(int[][] image) {
		List<Rectangle> rectList = new ArrayList<Rectangle>();

		for (int v = 0; v < image.length; v++) {
			for (int h = 0; h < image[v].length; h++) {
				if (0 == image[v][h]) {
					// check if coordinate is part of found rectangle
					if (!partOfDiscoveredRectangle(rectList, v, h)) {
						discoverRectangle(rectList, image, v, h);
					}
				}
			}
		}

		return rectList;
	}
	
	private static boolean partOfDiscoveredRectangle(List<Rectangle> rectangleList, int v, int h) {
		if (rectangleList.isEmpty()) return false;
		
		for (Rectangle rectangle : rectangleList) {
			int xFloor = rectangle.xCoordinate;
			int xCeiling = xFloor + rectangle.width;
			int yFloor = rectangle.yCoordinate;
			int yCeiling = yFloor + rectangle.height;
					
			if ( v >= yFloor && v <= yCeiling &&
				 h >= xFloor && h <= xCeiling) {
				return true;
			}
		}
		
		return false;
	}
	
	private static void discoverRectangle(List<Rectangle> rectangleList, int[][] image, int v, int h) {
		Rectangle rectangle = new Rectangle();
		rectangle.xCoordinate = h;
		rectangle.yCoordinate = v;
		
		// go down
		while (v < image.length && image[v][h] != 1) {
			rectangle.height++;
			v++;
		}
		
		// go right
		v--;
		while (h < image[v].length && image[v][h] != 1) {
			rectangle.width++;
			h++;
		}
		
		rectangleList.add(rectangle);
	}

	static class Rectangle {
		int width = 0;
		int height = 0;
		int xCoordinate = -1;
		int yCoordinate = -1;
	}
	
	public static void main(String[] args) {
	    int[][] image = {  
	      {0, 1, 1, 1, 1, 1, 1},
	      {1, 1, 1, 0, 0, 0, 1},
	      {1, 0, 1, 0, 0, 0, 1},
	      {1, 0, 1, 1, 1, 1, 1},
	      {1, 0, 1, 0, 0, 1, 1},
	      {1, 1, 1, 0, 0, 1, 1},
	      {1, 1, 1, 0, 0, 1, 1},
	      {1, 1, 1, 0, 0, 1, 0}
	    };
	    
	    List<Rectangle> rectangleList = findRectangle(image);
	    for (Rectangle rectangle : rectangleList){
	      System.out.println("Top left coordinate: " + rectangle.xCoordinate + "," + rectangle.yCoordinate);
	      System.out.println("Width of rectangle: " + rectangle.width);
	      System.out.println("Height of rectangle: " + rectangle.height);
	      System.out.println("*************************");
	    }
	  }
}
