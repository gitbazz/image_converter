
/*
 * Class that uses a threshold filter to display each pixel of an image as either black or white. 
 * If the “brightness score” of a given pixel is greater than 100, the color of the pixel is changed to white, otherwise it is changed to black. 
 * @author Bazillah Zargar
 */

import java.awt.Color;

public class ThresholdingOperation implements ImageOperation {

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		/* 2-dimensional array to store the processed image */
		Color[][] result = new Color[numOfRows][numOfColumns];

		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				/* Calculate brightness score for each pixel */
				double brightnessScore = (0.21 * imageArray[i][j].getRed()) + (0.71 * imageArray[i][j].getGreen())
						+ (0.07 * imageArray[i][j].getBlue());
				/*
				 * If the brightness score is greater than 100, the pixel is changed to white,
				 * otherwise it is changed to black.
				 */
				if (brightnessScore > 100) {
					int red = 255;
					int green = 255;
					int blue = 255;
					result[i][j] = new Color(red, green, blue);
				} else {
					int red = 0;
					int green = 0;
					int blue = 0;
					result[i][j] = new Color(red, green, blue);
				}

			}
		return result;
	}

}
