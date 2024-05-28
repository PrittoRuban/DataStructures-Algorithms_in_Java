// Array need to be sorted
// Time complexity: O(log n)
// Space complexity: O(1)

public class BinarySearchAlgo {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40, 50 , 60 , 70, 80, 90, 100};
        int x = 10;
        int result = binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }

    public static int binarySearch(int[] arr, int x) {
        int start = 0; 
        int end = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == x) {
                return mid;
            }
            else if(arr[mid] < x) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
