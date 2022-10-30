package by.bsuir.task5;

public class SortArray {
    private SortArray() {}

    public static int removeElementsCount(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            count += array[i] > array[i + 1] ? 1 : 0;
        }
        return count;
    }
}
