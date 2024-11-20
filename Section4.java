import java.util.Arrays;

public class Section4 {
    public static void main(String[] args) {
        // Topics discussed: Binary Search, Merge Sort, Quick Sort.
        // Approach utilized & discussed: Divide and Conquer.

        // Testing task algorithm
        System.out.println(checkChar("hello", 'l', 0, 4));

        // Testing quickSort implementation
        int[] test = new int[]{3, 2, 4, 12, 5, 13, 7};
        quickSort(test, 0, 4);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(mergeSort(test)));
    }

    // Merge Sort:
    public static int[] mergeSort(int[] arr) {
        int n = arr.length;

        if (n == 2) { return Section3.mergeSorted(new int[] {arr[0]}, new int[] {arr[1]}); }

        if (n > 1) {
            int mid = (int) Math.floor(n / 2.0);
            return Section3.mergeSorted(mergeSort(Arrays.copyOfRange(arr, 0, mid+1)), Arrays.copyOfRange(arr, mid+1, n));
        }

        return arr;
    }

    // Quick Sort:
    public static void quickSort(int[] arr, int low, int high) {
        if (high > low) {
            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotPoint = high;

        int item = arr[pivotPoint];

        int j = low;

        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < item) {
                j++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        arr[pivotPoint] = arr[j];
        pivotPoint = j;
        arr[pivotPoint] = item;

        return pivotPoint;
    }

    // TASK: using divide and conquer check if the string S has the character c (passed) within it (case-sensitive)
    public static boolean checkChar(String s, char c, int low, int high) {
        if (low >= high) return s.charAt(low) == c;

        return (checkChar(s, c, low + 1, high) ||
                checkChar(s, c, low, high - 1) ||
                s.charAt(low) == c ||
                s.charAt(high) == c);
    }
}
