public class Main {
    public static void main(String[] args) {
        //For task2
        int[][] matrix = {
                {50, 107, 36},
                {35, 54, 20},
                {31, 66, 21}
        };

        //For task 3
        double[][] A = {
                {1, 10, 1},
                {2, 0, 1},
                {3, 3, 2}
        };
        double[][] B = {
                {0.4, 2.4, -1.4},
                {0.14, 0.14, -0.14},
                {-0.85, -3.8, 2.8}
        };

        //For task4
        double[][] matrix2 = {
                {2, -1, 0},
                {-1, 2, -1},
                {0, -1, 2}
        };
        double[] initialVector = {1,0,0};
        Task2 task2 = new Task2();
        task2.luFactor(matrix);

        Task3 task3 = new Task3();
        task3.iterativeInverse(A,B,5);

        Task4 task4 = new Task4();
        task4.findLargestEigenvalue(matrix2,initialVector,100,1e-6);




    }
}
