package part2;

public class DynProg {

    double Occlusion = 3.8;
    int N;
    int M;
    double C[][];

    public void forwardpass() {
        for (int i = 1; i <= N; i++) {
            C[i][0] = i * Occlusion;
        }
        for (int i = 1; i <= M; i++) {
            C[0][i] = i * Occlusion;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                C[i][j] = Math.min(C[i - 1][j - 1] + c(i, j), Math.min(C[i][j - 1] + Occlusion, C[i - 1][j] + Occlusion));

            }
        }
    }

    double[][] z1;
    double[][] z2;

    public double c(int a, int b) {
        double cost_function = (1 / 64) * (z1[b][a] - z2[b][b]);
        return cost_function;
    }
}



