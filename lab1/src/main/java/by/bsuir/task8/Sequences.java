package by.bsuir.task8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Sequences {
    private Sequences() {}

    public static int[] insertSequences(int[] destinationSequence, int[] secondSequence) {
        if (destinationSequence == null || secondSequence == null) {
            throw new IllegalArgumentException();
        }

        int[] concatedSequence = IntStream.concat(Arrays.stream(destinationSequence), Arrays.stream(secondSequence)).sorted().toArray();

        return findIndexes(concatedSequence, secondSequence);
    }

    private static int[] findIndexes(int[] inSequence, int[] fromSequence) {
        List<Integer> fromSequenceList = Arrays.stream(fromSequence).boxed().toList();
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < inSequence.length; i++) {
            if (fromSequenceList.contains(inSequence[i])) {
                indexes.add(i);
            }
        }

        return indexes.stream().mapToInt(num -> num).toArray();
    }
}
