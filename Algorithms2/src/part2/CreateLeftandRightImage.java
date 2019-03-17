package part2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class CreateLeftandRightImage {
    double[][] MATRIX;
    double[][] SecondImage;
    public CreateLeftandRightImage(double[][] MATRIX,double[][] SecondImage)
    {
     this.MATRIX=MATRIX;
     this.SecondImage=SecondImage;
    }

    /*
        Part 3
        (iii) now create a left image L by placing the 256x256 image B into the 512x512 image A such
         that the top-left corner of the 256x256 image B starts at (124,128),
        */

    public void makeLeftImage(){

        double[][] leftImage = MATRIX.clone();
        double[][] imageB = SecondImage.clone();
        int height = leftImage.length;
        int width = leftImage[0].length;

        for (int i = 0; i < imageB.length; i++)
            for (int j = 0; j < imageB[i].length; j++)
                leftImage[128 + i][124 + j] = imageB[i][j];

        BufferedImage bi3 = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster3 = bi3.getRaster();
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                raster3.setPixel(x, y, new double[]{leftImage[y][x]});
        try {
            ImageIO.write(bi3, "jpg", new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\LeftImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        Part 4
        (iv) now create the right image R by placing the top-left corner of the 256x256 image B at (132,128).
         */

    public void makeRightImage(){

        double[][] rightImage = MATRIX.clone();
        double[][] imageB = SecondImage.clone();
        int height = rightImage.length;
        int width = rightImage[0].length;

        for (int i = 0; i < imageB.length; i++)
            for (int j = 0; j < imageB[i].length; j++)
                rightImage[128 + i][132 + j] = imageB[i][j];

        BufferedImage bi4 = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster4 = bi4.getRaster();
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                raster4.setPixel(x, y, new double[]{rightImage[y][x]});
        try {
            ImageIO.write(bi4, "jpg", new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\RightImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
