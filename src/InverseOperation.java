import java.awt.Color;

public class InverseOperation implements ImageOperation {

	public Color[][] doOperation(Color[][] imageArray) {
		int numOfRows = imageArray.length;
		int numOfColumns = imageArray[0].length;

		/* 2-dimensional array to store the processed image */
		Color[][] result = new Color[numOfRows][numOfColumns];

		/* Scan the array and invert each color */
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfColumns; j++) {
				int red = 255 - imageArray[i][j].getRed();
				int green = 255 - imageArray[i][j].getGreen();
				int blue = 255 - imageArray[i][j].getBlue();
				result[i][j] = new Color(red, green, blue);
			}
		return result;
	}

}
