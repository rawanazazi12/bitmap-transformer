package bimap;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    private String inputFilePath;
    private String outputFilePath;
    private String newFileName;
    private BufferedImage image = null;

    public Bitmap(String inputFilePath, String outputFilePath, String newFileName) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
        this.newFileName = newFileName;
    }

    public boolean readFile() {
        try {
            File file = new File(this.inputFilePath);
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveFile() {
        try {
            File outputFile = new File(this.outputFilePath + this.newFileName);
            ImageIO.write(this.image, "bmp", outputFile);
        } catch (IOException e) {
            System.out.println("File not found");
            return false;
        }
        return true;
    }

    //convert to grayScale
    public boolean grayScale() {
        int height = this.image.getHeight();
        int width = this.image.getWidth();

        for (int h = 1; h < height; h++) {
            for (int w = 1; w < width; w++) {
                int p = this.image.getRGB(w,h);
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                //      calculate avg color
                int avg = (r+g+b)/3;

                //    replace RGB value with avg

                p = (avg<<24) | (avg<<16) | (avg<<8) | avg;

                this.image.setRGB(w, h, p);
            }
        }
        return true;
    }

    public int imageFlipHorizontal() {

        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int lastRGBVal = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.image.setRGB((width - 1) - x, y, this.image.getRGB(x, y));
                lastRGBVal = this.image.getRGB(width - 1 - x, y);
            }
        }
        return lastRGBVal;

    }

    public int imageFlipVertical() {

        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int lastRGBVal = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.image.setRGB(x, (height - 1) - y, this.image.getRGB(x, y));
                lastRGBVal = this.image.getRGB(x, height - 1 - y);
            }
        }
        return lastRGBVal;
    }
}

