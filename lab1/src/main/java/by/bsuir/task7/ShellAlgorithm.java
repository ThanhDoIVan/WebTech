package by.bsuir.task7;

public class ShellAlgorithm {
    private ShellAlgorithm() {}

    public static int[] sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }

        int i = 0;
        while (i < array.length - 1){
            if (array[i] > array[i+1]){
                int temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
                i -= i > 0 ? 1 : 0;
            }
            else {
                i++;
            }
        }
        return array;
    }
}
