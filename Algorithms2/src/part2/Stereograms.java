package part2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Stereograms {

    /*
        Part 1
        (i) create a 512x512 image A of random black and white pixels (0 and 255 as pixel values),
        */

    int width = 512, height = 512;

    public double[][] makeImageA() {



        double[][] data = new double[height][width];
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                data[i][j] = ThreadLocalRandom.current().nextInt(0, 256);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = bi.getRaster();
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                raster.setPixel(x, y, new double[]{data[y][x]});

        try {
            ImageIO.write(bi, "jpg", new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\ImageA.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


        /*
        Part 2
        (ii) create a second 256x256 image B of random black and white pixels (0 and 255 as pixel values),
        */
        public double[][] makeImageB(){

        int width = 256, height = 256;

            double[][] data = new double[height][width];
            for (int i = 0; i < height; i++)
                for (int j = 0; j < width; j++)
                    data[i][j] = ThreadLocalRandom.current().nextInt(0, 256);

            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            WritableRaster raster = bi.getRaster();
            for (int y = 0; y < height; y++)
                for (int x = 0; x < width; x++)
                    raster.setPixel(x, y, new double[]{data[y][x]});

            try {
                ImageIO.write(bi, "jpg", new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\ImageB.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
    }


}
