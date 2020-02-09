
/* 
 * Class that performs contour detection of an image, by examining the “color distance” between a pixel and its neighboring pixels. 
 * If the color distance between a given pixel and its neighbors is greater than 65, it is considered to be a contour.
 * @author Bazillah Zargar
 */

import java.awt.Color;

public class ContourOperation implements ImageOperation {

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		/* 2-dimensional array to store the processed image */
		Color[][] result = new Color[numOfRows][numOfColumns];

		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				/* Check if current pixel has neighbors */
				if (i > 0 & j > 0 & i < (numOfRows - 1) & j < (numOfColumns - 1)) {
					/* Calculate “color distance” between neighboring pixels */
					double colorDistUpLeft = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i - 1][j - 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i - 1][j - 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i - 1][j - 1].getBlue()), 2));
					double colorDistLeft = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i - 1][j].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i - 1][j].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i - 1][j].getBlue()), 2));
					double colorDistDownLeft = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i - 1][j + 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i - 1][j + 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i - 1][j + 1].getBlue()), 2));
					double colorDistUp = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i][j - 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i][j - 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i][j - 1].getBlue()), 2));
					double colorDistDown = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i][j + 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i][j + 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i][j + 1].getBlue()), 2));
					double colorDistUpRight = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i + 1][j - 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i + 1][j - 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i + 1][j - 1].getBlue()), 2));
					double colorDistRight = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i + 1][j].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i + 1][j].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i + 1][j].getBlue()), 2));
					double colorDistDownRight = Math
							.sqrt(Math.pow((imageArray[i][j].getRed() - imageArray[i + 1][j + 1].getRed()), 2)
									+ Math.pow((imageArray[i][j].getGreen() - imageArray[i + 1][j + 1].getGreen()), 2)
									+ Math.pow((imageArray[i][j].getBlue() - imageArray[i + 1][j + 1].getBlue()), 2));
					/*
					 * If color distance between neighboring pixels is greater than 65 change the
					 * color of that pixel to black, otherwise change the color of that pixel to
					 * white.
					 */
					if (colorDistUpLeft > 65 | colorDistLeft > 65 | colorDistDownLeft > 65 | colorDistUp > 65
							| colorDistDown > 65 | colorDistUpRight > 65 | colorDistRight > 65
							| colorDistDownRight > 65) {
						int red = 0;
						int green = 0;
						int blue = 0;
						result[i][j] = new Color(red, green, blue);
					} else {
						int red = 255;
						int green = 255;
						int blue = 255;
						result[i][j] = new Color(red, green, blue);
					}
					/* If current pixel does not have neighbors change it's color to white */
				} else {
					int red = 255;
					int green = 255;
					int blue = 255;
					result[i][j] = new Color(red, green, blue);
				}
			}
		return result;
	}

}
