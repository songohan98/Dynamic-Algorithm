package part2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ConvertImagetoGreyScale {

    public double[][] getPixelValue(String name) throws IOException {

        double[][] z;
        BufferedImage bi;
        bi = ImageIO.read(getClass().getResource(name));

        z = new double[bi.getHeight()][bi.getWidth()];
        for (int i = 0; i < bi.getHeight(); i++)
            for (int j = 0; j < bi.getWidth(); j++){
                Color c = new Color(bi.getRGB(j,i));
                z[i][j] = (0.2989*c.getRed())+(0.5870*c.getGreen())+(0.1140*c.getBlue());
            }

        return z;
    }

}
