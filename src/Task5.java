import java.util.Arrays;

public class Task5 {
    public static double[] multiplyMatrixVector(double[][] matrix, double[] vector) {
        int n = matrix.length;
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }


    public static int[] findMaxOffDiagonal(double[][] matrix) {
        int n = matrix.length;
        int[] maxIndices = new int[2];
        double max = 0.0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(matrix[i][j]) > max) {
                    max = Math.abs(matrix[i][j]);
                    maxIndices[0] = i;
                    maxIndices[1] = j;
                }
            }
        }

        return maxIndices;
    }

    public static void rotate(double[][] matrix, double[][] eigenvectors, int i, int j) {
        int n = matrix.length;
        if (matrix[i][j] != 0.0) {
            double theta = 0.5 * Math.atan2(2 * matrix[i][j], matrix[j][j] - matrix[i][i]);
            double cosTheta = Math.cos(theta);
            double sinTheta = Math.sin(theta);

            double temp = matrix[i][i];
            matrix[i][i] = cosTheta * cosTheta * matrix[i][i] - 2 * cosTheta * sinTheta * matrix[i][j] + sinTheta * sinTheta * matrix[j][j];
            matrix[j][j] = sinTheta * sinTheta * temp + 2 * cosTheta * sinTheta * matrix[i][j] + cosTheta * cosTheta * matrix[j][j];
            matrix[i][j] = 0.0;
            matrix[j][i] = 0.0;


            for (int k = 0; k < n; k++) {
                double tempVec = eigenvectors[k][i];
                eigenvectors[k][i] = cosTheta * eigenvectors[k][i] - sinTheta * eigenvectors[k][j];
                eigenvectors[k][j] = sinTheta * tempVec + cosTheta * eigenvectors[k][j];
            }


            for (int k = 0; k < n; k++) {
                if (k != i && k != j) {
                    double temp1 = matrix[i][k];
                    double temp2 = matrix[j][k];
                    matrix[i][k] = cosTheta * temp1 - sinTheta * temp2;
                    matrix[j][k] = sinTheta * temp1 + cosTheta * temp2;
                    matrix[k][i] = matrix[i][k];
                    matrix[k][j] = matrix[j][k];
                }
            }
        }
    }

    public static void jacobiMethod(double[][] matrix) {
        int n = matrix.length;
        double[][] eigenvectors = new double[n][n];
        for (int i = 0; i < n; i++) {
            eigenvectors[i][i] = 1.0;
        }

        int iterations = 0;
        double epsilon = 1e-9;

        while (true) {
            int[] maxIndices = findMaxOffDiagonal(matrix);
            int i = maxIndices[0];
            int j = maxIndices[1];

            if (Math.abs(matrix[i][j]) < epsilon) {
                break;

                rotate(matrix, eigenvectors, i, j);
                iterations++;
            }

            System.out.println("Собственные значения:");
            for (int i = 0; i < n; i++) {
                System.out.println(matrix[i][i]);
            }

            System.out.println("\nСобственные векторы:");
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(eigenvectors[i]));
            }
        }
    }
}
