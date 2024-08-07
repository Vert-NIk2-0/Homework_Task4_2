import java.text.DecimalFormat;
import java.util.Random;

public class JavaTask4 {
    public static void main(String[] args) {
        double[] vector = new double[3];
        double[][] matrix = new double[2][3];
        double[][] secondMatrix = new double[3][2];
        Random rand = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.#");

//      Вектор ====================================
        System.out.println("Vector:");
        for (int i = 0; i < vector.length; i++) {

            vector[i] = Double.parseDouble(decimalFormat.format(rand.nextDouble(21)));
            System.out.printf("%.1f\n", vector[i]);

        }

//      Матрица 1 ===================================
        System.out.println("\nMatrix 1:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                matrix[i][j] = Double.parseDouble(decimalFormat.format(rand.nextDouble(21)));
                if (matrix[i][j] < 10) {
                    System.out.printf("%.1f  ", matrix[i][j]);
                } else System.out.printf("%.1f ", matrix[i][j]);

            }
            System.out.println();
        }

//      Матрица 2 ===================================
        System.out.println("\nMatrix 2:");
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[0].length; j++) {

                secondMatrix[i][j] = Double.parseDouble(decimalFormat.format(rand.nextDouble(21)));
                if (secondMatrix[i][j] < 10) {
                    System.out.printf("%.1f  ", secondMatrix[i][j]);
                } else System.out.printf("%.1f ", secondMatrix[i][j]);

            }
            System.out.println();
        }

//      Перемножение матрицы и вектора
        System.out.println("\nMatrix x Vector =");
        double[] resultMatrixAndVector = mul(matrix, vector);
        if (resultMatrixAndVector != null) {
            for (double elem : resultMatrixAndVector) {
                System.out.printf("%.1f\n", elem);
            }
        }


//      Перемножение матрицы и матрицы
        System.out.println("\nMatrix x Matrix =");
        double[][] resultMatrixAndMatrix = mul(matrix, secondMatrix);
        if (resultMatrixAndMatrix != null) {
            for (int i = 0; i < resultMatrixAndMatrix.length; i++) {
                for (int j = 0; j < resultMatrixAndMatrix[0].length; j++) {
                    if (resultMatrixAndMatrix[i][j] < 10) {
                        System.out.printf("%.1f  ", resultMatrixAndMatrix[i][j]);
                    } else System.out.printf("%.1f ", resultMatrixAndMatrix[i][j]);

                }
                System.out.println();
            }
        }

    }

    static double[] mul(double[][] matrix, double[] vector) {
        if (vector.length == matrix[0].length) {
            double[] resultMatrixAndVector = new double[matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    resultMatrixAndVector[i] += matrix[i][j] * vector[j];
                }
            }

            return resultMatrixAndVector;
        } else {
            System.out.println("The number of matrix columns must match the length of the vector");
            return null;
        }
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        if (matrixLeft[0].length == matrixRight.length) {
            double[][] resultMatrixAndMatrix = new double[matrixLeft.length][matrixRight[0].length];

            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixLeft[0].length; k++) {
                        resultMatrixAndMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                    }

                }
            }

            return resultMatrixAndMatrix;
        } else {
            System.out.println("The number of columns in the matrixLeft must match the number of terms in the matrixRight.");
            return null;
        }
    }

}