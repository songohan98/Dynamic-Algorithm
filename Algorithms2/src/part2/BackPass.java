package part2;

public class BackPass {
    double[][] z1;
    double[][] z2;
    int R;
    int N;
    int M;
    public BackPass(double[][] z1,double[][] z2)
    {
        this.z1 = z1;
        this.z2 = z2;
        this.R = Math.max(z1.length,z2.length);
        this.N = z1[R-1].length;
        this.M = z2[R-1].length;
    }
    public double[][] backPass(double[][][] threeDMatchMatrix)
    {
        double[][][] Match = threeDMatchMatrix;
        double[][] result = new double[R][N];
        for(int k =0;k<R;k++)
        {
            int i = N - 1;
            int j = i;

            while (i > 0 && j > 0) {
                if (Match[k][i][j] == 1) {
                    result[k][i] = (i - j) * 10;
                    i--;
                    j--;
                }
                if (Match[k][i][j] == 2) {
                    result[k][i] = 0;
                    j--;

                }
                if (Match[k][i][j] == 3) {
                    i--;
                }
            }
        }
        return result;
    }
}
