package by.bsuir.task6;

public class Matrix {
    private Matrix() {}

    public static int[][] buildMatrix(int[] numbers) {
        int[][] resultMatrix = new int[numbers.length][numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                resultMatrix[i][j] = numbers[(j + i) % numbers.length];
            }
        }

        return resultMatrix;
    }
}
