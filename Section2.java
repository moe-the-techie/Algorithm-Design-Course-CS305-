import java.util.Arrays;

public class Section2 {
    // Solving P.set 1.1 (page 59)
    public static void main(String[] args) {
        try {
            // Testing P1's solution
            System.out.println(findMax(new int[]{1, 22, 3, 43, 12}));

            // Testing P2's solution
            System.out.println(Arrays.toString(findSmallestM(new int[]{0, 24, 74, 5, 13, 4}, 4)));

            // Testing P6's solution
            System.out.println(Arrays.toString(findMaxAndMin(new int[]{17, 22, 34, 25, 12, 4, 0})));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Testing P3's solution
        printTriplets(new int[]{12, 32, 42, 123, 42, 65, 99});

        // Test P7's solution
        System.out.println(findIndex(13, new int[]{1, 3, 12, 15, 26}));
    }

    // Problem 1: finding the maximum number in a list.
    public static int findMax(int[] arr) {
        if (arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
        // Looking at the time complexity, we find that this has O(n) complexity in all cases.
    }

    // P2: Finding the m smallest numbers.
    public static int[] findSmallestM(int[] arr, int m) {
        int[] res = new int[m];

        if (arr.length < m || m == 0) throw new IllegalArgumentException("Array size can't be less than m");
        if (arr.length == m) return arr;

        int min = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            arr[minIndex] = Integer.MAX_VALUE;
            res[i] = min;
        }

        return res;
    }

    // P3: Printing all subsets of size 3
    public static void printTriplets(int[] arr) {
        if (arr.length <= 3) System.out.println(Arrays.toString(arr));

        int[] subset = new int[3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    subset[0] = arr[i];
                    subset[1] = arr[j];
                    subset[2] = arr[k];
                    System.out.println(Arrays.toString(subset));
                }
            }
        }
    }

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

    // TASK: getIndex of sorted array in O(nlog(n))
    public static int findIndex(int target, int[] arr) {
        if (arr[arr.length - 1] < target) return arr.length;
        if (arr[0] > target) return 0;

        // A Binary Search algorithm is sufficient

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
