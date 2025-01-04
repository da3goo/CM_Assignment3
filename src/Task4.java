import java.util.Arrays;

public class Task4 {
    //EigenvalueFinder

    public static double vectorNorm(double[] v) {
        double sum = 0.0;
        for (double val : v) {
            sum += val * val;
        }
        return Math.sqrt(sum);
    }


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


    public void findLargestEigenvalue(double[][] matrix, double[] initialVector, int maxIterations, double tolerance) {
        int n = matrix.length;
        double[] b = Arrays.copyOf(initialVector, n);
        double eigenvalue = 0.0;

        for (int iter = 0; iter < maxIterations; iter++) {
            double[] newVector = multiplyMatrixVector(matrix, b);
            double norm = vectorNorm(newVector);

            for (int i = 0; i < n; i++) {
                newVector[i] /= norm;
            }

            double newEigenvalue = 0.0;
            for (int i = 0; i < n; i++) {
                newEigenvalue += newVector[i] * b[i];
            }

            if (Math.abs(newEigenvalue - eigenvalue) < tolerance) {
                eigenvalue = newEigenvalue;
                b = newVector;
                break;
            }

            eigenvalue = newEigenvalue;
            b = newVector;
        }
        System.out.println();
        System.out.println("Task 4");
        System.out.println("The largest eigenvalue: " + eigenvalue);
        System.out.println("The corresponding eigenvector: " + Arrays.toString(b));
    }
}
