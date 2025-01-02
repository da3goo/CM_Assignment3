public class Task2 {
    public void luFactor(int[][] matrix){
        double[][] L = new double[3][3];
        double[][] U = new double[3][3];

        for (int i = 0 ;i < 3; i++){
            L[i][i] = 1;
        }

        for (int k = 0; k < 3; k++) {
            // Вычисление элементов U
            for (int j = k; j < 3; j++) {
                U[k][j] = matrix[k][j];
                for (int p = 0; p < k; p++) {
                    U[k][j] -= L[k][p] * U[p][j];
                }
            }
            // Вычисление элементов L
            for (int i = k + 1; i < 3; i++) {
                L[i][k] = matrix[i][k];
                for (int p = 0; p < k; p++) {
                    L[i][k] -= L[i][p] * U[p][k];
                }
                L[i][k] /= U[k][k];
            }
        }
        // Вывод матриц L и U
        System.out.println("Matrix L:");
        printMatrix(L);

        System.out.println("Matrix U:");
        printMatrix(U);

    }



    private void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.printf("%8.3f", value);
            }
            System.out.println();
        }
    }
}
