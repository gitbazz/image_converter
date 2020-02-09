# Image Converter

Takes an image and performs the following operations: adustment, contour, inverse, magnify, thresholding

**AdjustmentOperation.java** class that changes the brightness of each pixel depending its Euclidean distance from the upper-left corner of the image.

**ContourOperation.java** class that performs contour detection of an image, by examining the “color distance” between a pixel and its neighboring pixels.

**InverseOperation.java** class that inverts the colour of an image.

**MagnifyOperation.java** class that changes the size of an image to twice its width and twice its height.

**ThresholdingOperation.java** class that uses a threshold filter to display each pixel of an image as either black or white.
