import java.util.Arrays;

public class Section8 {
    public static void main(String[] args) {
        // Topic: Backtracking
        // Relevant problems: n queens, sum of subset

        // Testing n queens solution
        int n = 4;
        int[] queen_columns = new int[n];
        /*
            Since our algorithm is 0 indexed, we call with column -1 since the algorithm places the first queen at
            queen_columns[i+1].
         */
        queens(queen_columns, -1);

        // Testing sum of subsets solution
        int[] nums = new int[]{3, 4, 7, 10, 13, 17};
        boolean[] include = new boolean[nums.length];
        sumOfSubsets(-1, nums, include, 0, 20, Arrays.stream(nums).sum());
    }

    public static void queens(int[] queen_columns, int i) {
        /*
            Finds all solutions for placements of queens on a nxn chess board such that none of them can capture the
            other, where each entry represents the column in which the queen should be placed on the ith row.
            0 Indexed.
         */

        // Array queen_columns represents the indices the queen placed in each row
        if (promisingQueen(i, queen_columns)) {
            if (i == queen_columns.length - 1) {
                // If we reach the end, print the solution
                System.out.println(Arrays.toString(queen_columns));
            } else {
                // Try all possible placements of the queen, backtracks to the next iteration if not promising
                for (int j = 0; j < queen_columns.length; j++) {
                    queen_columns[i + 1] = j;
                    queens(queen_columns, i + 1);
                }
            }
        }
    }

    public static boolean promisingQueen(int i, int[] queen_columns) {
        int k = 0;
        boolean promising = true;

        // Check if queen placed at index 'i' can be taken by other queens on the board
        while (k < i && promising) {
            if (queen_columns[i] == queen_columns[k] || Math.abs(queen_columns[i] - queen_columns[k]) == i - k) {
                promising = false;
            }
            k++;
        }

        return promising;
    }

    public static void sumOfSubsets(int i, int[] nums, boolean[] include, int total, int target, int remainder) {
        /*
            Finds all the subsets of nums that add up to target using backtracking
         */
        if (promising(i, nums, target, total, remainder)) {
            if (total == target) {
                System.out.println("Include: " + Arrays.toString(include));
            } else {
                include[i + 1] = true;
                sumOfSubsets(i + 1,
                        nums,
                        include,
                        total + nums[i + 1],
                        target,
                        remainder - nums[i + 1]);

                include[i + 1] = false;
                sumOfSubsets(i + 1,
                        nums,
                        include,
                        total,
                        target,
                        remainder - nums[i + 1]);
            }
        }
    }

    public static boolean promising(int i, int[] nums, int target, int total, int remainder) {
        // Make sure to not continue when the end of the array is reached
        if (i == nums.length) return false;
        return (total + remainder >= target) && (total == target || total + nums[i+1] <= target);
    }
}
