package part2;

public class DynamicProgramming {
        double[][] z1;
        double[][] z2;
        int R;
        int N;
        int M;
        double occlusion;

        public DynamicProgramming(double[][] z1,double[][] z2,double occlusion){
            this.z1 = z1;
            this.z2 = z2;
            this.R = Math.max(z1.length,z2.length);
            this.N = z1[R-1].length;
            this.M = z2[R-1].length;
            this.occlusion = occlusion;
        }

        public double costFunction(int i ,int j,int k){
            double costfunction;
            costfunction = ((1/2)*(((z1[k][i]+ z2[k][j])/2) - z1[k][i])/16*(((z1[k][i]+ z2[k][j])/2) - z1[k][i])) + (0.5*(((z1[k][i]+ z2[k][j])/2) - z2[k][j])/16*(((z1[k][i]+ z2[k][j])/2) - z2[k][j]));
            return costfunction;
        }

        public static double min(double a, double b, double c) {
            if (a <= b && a <= c) return a;
            if (b <= a && b <= c) return b;
            return c;
        }
        public double[][][] FordwardPass()
        {

            double[][][] C = new double[R][N][M];
            double[][][] Match =new double[R][N][M];
            for(int k =0;k<R;k++)
            {
                for (int i = 0; i < N; i++) {
                    double input = i*occlusion;
                    C[k][i][0] = input;
                }
                for (int i = 0; i < M; i++) {
                    double input = i*occlusion;
                    C[k][0][i] = input;
                }
                for (int i = 1; i < N; i++)
                {
                    for (int j = 1; j < M; j++)
                    {
                        if(C[k][i-1][j-1] + costFunction(i,j,k)== min(C[k][i-1][j-1] + costFunction(i,j,k),C[k][i][j-1] + occlusion,C[k][i-1][j] + occlusion))
                        {Match[k][i][j]=1;}
                        if(C[k][i][j-1] + occlusion== min(C[k][i-1][j-1] + costFunction(i,j,k),C[k][i][j-1] + occlusion,C[k][i-1][j] + occlusion))
                        {Match[k][i][j]=2;}
                        if(C[k][i-1][j] + occlusion== min(C[k][i-1][j-1] + costFunction(i,j,k),C[k][i][j-1] + occlusion,C[k][i-1][j] + occlusion))
                        {Match[k][i][j]=3;}
                        C[k][i][j] = min(C[k][i-1][j-1] + costFunction(i,j,k),C[k][i][j-1] + occlusion,C[k][i-1][j] + occlusion);

                    }
                }
            }
            return Match;
        }

    }

