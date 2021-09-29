# bitmap-transformer

## Overview
Building a bitmap(.bmp) transformer CLI. It reads a bitmap from disk and applies 3 methods in the (.bmp) file to change it and then Write it out to a new file.

## Methods

1. inputFilePath: It is a String variable, and its purpose to store the path of the input (.bmp) file.

3. outputFilePath: It is a String variable, and its purpose to store the path of a new (.bmp) file.

4. newFileName: It is a String variable, and its purpose to store the name of a new (.bmp) file.

5. readFile(): This method reads the file that contains the image that we want to apply the change on it by creating a new variable from File class and store the path file in file variable. Also, we use the ImageIO.read(file) class to read the image and store it in image variable.

6. saveFile(): This method saves the new file after we applied the methods that make changes to it.

7. grayScale(): This is the first method for changing image color. It changes the image color to a gray color by calculating the average value of RGB and use this value to convert it into a gray image.

8. imageFlipHorizontal(): This method for flipping the image horizontally.

9. imageFlipVertical(): This method for flipping the image vertically.