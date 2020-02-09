
/*
 * Class that changes the brightness of each pixel depending its Euclidean distance from the upper-left corner of the image.
 * @author Bazillah Zargar
 */

import java.awt.Color;

public class AdjustmentOperation implements ImageOperation {

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		/* 2-dimensional array to store the processed image */
		Color[][] result = new Color[numOfRows][numOfColumns];

		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				/* Calculate distance to the upper left corner of the image */
				double distanceToCorner = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
				/*
				 * Calculate maximum distance from any pixel to the upper left corner of the
				 * image
				 */
				double maxDistance = Math.sqrt(Math.pow(numOfColumns, 2) + Math.pow(numOfRows, 2));
				/* Modify color of pixel */
				double adjustBrightness = distanceToCorner / maxDistance;
				double red = imageArray[i][j].getRed() * adjustBrightness;
				double green = imageArray[i][j].getGreen() * adjustBrightness;
				double blue = imageArray[i][j].getBlue() * adjustBrightness;
				int redFinal = (int) Math.round(red);
				int greenFinal = (int) Math.round(green);
				int blueFinal = (int) Math.round(blue);
				result[i][j] = new Color(redFinal, greenFinal, blueFinal);
			}
		return result;
	}

}
