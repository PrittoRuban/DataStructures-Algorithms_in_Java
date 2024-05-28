
// Array need not to be sorted
// Time complexity: O(n)
// Space complexity: O(1)

public class LinearSearchAlgo {
    public static void main(String[] args) {
        int[] arr = { 5, 6, 67, 45, 5, 3, 37, 3, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7};
        int x = 10;
        int result = linearSearch(arr, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }

    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
