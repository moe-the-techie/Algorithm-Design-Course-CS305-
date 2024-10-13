import java.util.Arrays;

public class Section2 {
    // Solving P.set 1.1
    public static void main(String[] args) {
        try {
            // Testing P1's solution
            System.out.println(findMax(new int[]{1, 22, 3, 43, 12}));

            // Testing P6's solution INCORRECT
            System.out.println(Arrays.toString(findMaxAndMin(new int[]{17, 22, 34, 25, 12, 4, 0})));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Test P7's solution
        System.out.println(findIndex(13, new int[]{1, 3, 12, 15, 26}));
    }

    // Problem 1: O(n)
    public static int findMax(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
        // Looking at the time complexity, we find that this has O(n) complexity in all cases.
    }

    // TODO: problems 2-5

    // P6: Max AND Min in O(3/2n)
    public static int[] findMaxAndMin(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");

        int max, min;
        max = min = arr[0];
        int tmpMin, tmpMax;

        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[2 * i] > arr[2 * i + 1]) {
                tmpMin = arr[2 * i + 1];
                tmpMax = arr[2 * i];
            } else {
                tmpMin = arr[2 * i];
                tmpMax = arr[2 * i + 1];
            }

            if (tmpMin < min) min = tmpMin;
            if (tmpMax > max) max = tmpMax;
        }

        if (arr.length % 2 != 0) {
            if (min > arr[arr.length - 1]) min = arr[arr.length - 1];
            if (max < arr[arr.length - 1]) max = arr[arr.length - 1];
        }

        return new int[]{max, min};
    }

    // P7 (task): getIndex of sorted array in O(nlog(n))
    public static int findIndex(int target, int[] arr) {
        if (arr[arr.length - 1] < target) return arr.length;
        if (arr[0] > target) return 0;

        int start = 0, end = arr.length - 1, mid = (start + end) / 2;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return mid;
    }
}
