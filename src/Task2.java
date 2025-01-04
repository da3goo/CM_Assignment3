public class Task2 {
    public void luFactor(int[][] matrix){
        System.out.println("Task 2");
        double[][] L = new double[3][3];
        double[][] U = new double[3][3];

        for (int i = 0 ;i < 3; i++){
            L[i][i] = 1;
        }

        for (int k = 0; k < 3; k++) {

            for (int j = k; j < 3; j++) {
                U[k][j] = matrix[k][j];
                for (int p = 0; p < k; p++) {
                    U[k][j] -= L[k][p] * U[p][j];
                }
            }

            for (int i = k + 1; i < 3; i++) {
                L[i][k] = matrix[i][k];
                for (int p = 0; p < k; p++) {
                    L[i][k] -= L[i][p] * U[p][k];
                }
                L[i][k] /= U[k][k];
            }
        }
        System.out.println("Lu factorization");

        System.out.println("Matrix L:");
        printMatrix(L);

        System.out.println("Matrix U:");
        printMatrix(U);

    }



    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.3f", value);
            }
            System.out.println();
        }
    }
}
