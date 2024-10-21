import java.util.Arrays;

public class Section3 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSorted(new int[]{1, 2, 3, 5}, new int[]{2, 4, 6})));
    }

    // P1 (task): Merge 2 sorted arrays with O(n)
    public static int[] mergeSorted (int[] arr1, int[] arr2) {
        int pointer1 = 0;
        int pointer2 = 0;
        int pointer3 = 0;

        int[] out = new int[arr1.length + arr2.length];

        // Works if both arrays have elements to be compared to each other
        while (pointer1 < arr1.length && pointer2 < arr2.length) {
            if (arr1[pointer1] <= arr2[pointer2]) {
                out[pointer3] = arr1[pointer1];
                pointer1++;
                pointer3++;
            } else {
                out[pointer3] = arr2[pointer2];
                pointer2++;
                pointer3++;
            }
        }

        // Empty out arr1 and arr2 if either still has elements
        while (pointer2 < arr2.length) {
            out[pointer3] = arr2[pointer2];
            pointer2++;
            pointer3++;
        }

        while (pointer1 < arr1.length) {
            out[pointer3] = arr1[pointer1];
            pointer1++;
            pointer3++;
        }

        return out;
    }
}