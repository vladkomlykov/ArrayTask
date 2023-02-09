import java.util.HashMap;
import java.util.Map;

public class ArrayAdd {
    public void trueArray() {

        int[] input = {0, 4, 6, 6, 8, 8, 7};

        System.out.println(findResultingNumber(input));
    }

    public static int findResultingNumber(int[] input) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : input) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        int[] countArray = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            countArray[index++] = entry.getValue();
        }
        while (countArray.length > 1) {
            int[] newCountArray = new int[countArray.length / 2 + countArray.length % 2];
            int newIndex = 0;
            for (int i = 0; i < countArray.length; i += 2) {
                if (i + 1 < countArray.length) {
                    newCountArray[newIndex++] = countArray[i] + countArray[i + 1];
                } else {
                    newCountArray[newIndex++] = countArray[i];
                }
            }
            countArray = newCountArray;
        }
        return countArray[0];
    }
}


