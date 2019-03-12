package part2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Stereograms {
    public static void main(String[] args) throws IOException {

        /*
        Part 1
        (i) create a 512x512 image A of random black and white pixels (0 and 255 as pixel values),
        */

        int width = 512, height = 512;

        int[][] data = new int[height][width];
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                data[i][j] = ThreadLocalRandom.current().nextInt(0, 256);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = bi.getRaster();
        for(int y=0; y < height; y++)
            for(int x=0; x < width; x++)
                raster.setPixel(x, y, new int[]{data[y][x]});

        ImageIO.write(bi, "jpg", new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\512x512.jpg"));


        /*
        Part 2
        (ii) create a second 256x256 image B of random black and white pixels (0 and 255 as pixel values),
        */

        int width2= 256, height2= 256;

        int[][] data2 = new int[height2][width2];
        for(int i = height2;i<height2;i++)
            for(int j = width2;j<width2;j++)
                data2[i][j]= ThreadLocalRandom.current().nextInt(0,256);

        BufferedImage bi2 = new BufferedImage(width2,height2,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster2 = bi2.getRaster();
        for(int y=0; y < height2; y++)
            for(int x=0; x < width2; x++)
                raster2.setPixel(x,y,new int[]{data[y][x]});
        ImageIO.write(bi2,"jpg",new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\256X256.jpg"));




    }
}
