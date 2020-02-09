
/* 
 * Class that changes the size of an image to twice its width and twice its height.
 * @author Bazillah Zargar
 */

import java.awt.Color;

public class MagnifyOperation implements ImageOperation {

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		/* 2-dimensional array to store the processed image */
		Color[][] result = new Color[numOfRows * 2][numOfColumns * 2];

		/*
		 * Copy each pixel of the original image into 4 positions of the enlarged array
		 */
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				int red = imageArray[i][j].getRed();
				int green = imageArray[i][j].getGreen();
				int blue = imageArray[i][j].getBlue();
				result[i * 2][j * 2] = new Color(red, green, blue);
				result[i * 2 + 1][j * 2] = new Color(red, green, blue);
				result[i * 2][j * 2 + 1] = new Color(red, green, blue);
				result[i * 2 + 1][j * 2 + 1] = new Color(red, green, blue);
			}
		return result;
	}

}
