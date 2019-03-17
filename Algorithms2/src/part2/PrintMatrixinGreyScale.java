package part2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class PrintMatrixinGreyScale {

    public void printCostMatrix(double[][] MatrixToPrint,String Nameofimage) throws IOException
    {
        double[][] Matrix = MatrixToPrint;
        String name = Nameofimage;
 
        BufferedImage bi = new BufferedImage(Matrix[0].length, Matrix.length, BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster raster = bi.getRaster();
        for (int y = 0; y < Matrix.length; y++)
            for (int x = 0; x < Matrix[y].length; x++)
                raster.setPixel(x, y, new double[]{Matrix[y][x]});
            
        ImageIO.write(bi, "jpg", new File("C:\\Users\\sciso\\IdeaProjects\\Algorithms2\\src\\part2\\"+name+".jpg"));
        
    }
}
