package part2;

public class Main {
    public static void main(String[] args) throws Exception
    {
/*
 This part is for making stereograms and should be executed with the Dynamic programming part
  */
//-----------------------------------------------------------------------------------------------

//        Stereograms rds = new Stereograms();
//        CreateLeftandRightImage clr = new CreateLeftandRightImage(rds.makeImageA(),rds.makeImageB());
//        clr.makeLeftImage();
//        clr.makeRightImage();

//----------------------------------------------------------------------------------------------//


/*
Dynamic Programming
 */
//---------------------------------------------------------------------------------------------
        String leftVision = "LeftImage.jpg";
        String RightVision = "RightImage.jpg";
        double occlusion = 3.8;

        ConvertImagetoGreyScale conv = new ConvertImagetoGreyScale();
        double[][] z1 = conv.getPixelValue(leftVision);
        double[][] z2 = conv.getPixelValue(RightVision);

        DynamicProgramming dynProg = new DynamicProgramming(z1,z2,occlusion);
        double[][][] Matrix3d = dynProg.FordwardPass();

        BackPass retrace = new BackPass(z1,z2);
        double[][] printMatrix = retrace.backPass(Matrix3d);

        PrintMatrixinGreyScale print = new PrintMatrixinGreyScale();
        print.printCostMatrix(printMatrix,"DisparityMap"+occlusion);

    }
}
