public class Task3 {
    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    public static double[][] subtractMatrices(double[][] A, double[][] B) {
        int n = A.length;
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }
    public static double[][] identityMatrix(int n) {
        double[][] identity = new double[n][n];
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1.0;
        }
        return identity;
    }
    public void iterativeInverse(double[][] A, double[][] B, int iterations) {
        System.out.println();
        System.out.println("Task 3");
        System.out.println("Iterative inverse:");
        System.out.println();
        int n = A.length;
        double[][] I = identityMatrix(n);

        for (int iter = 0; iter < iterations; iter++) {
            double[][] AB = multiplyMatrices(A, B);
            double[][] correction = subtractMatrices(I, AB);
            B = multiplyMatrices(B, correction);
        }

        Task2.printMatrix(B);
    }


}
