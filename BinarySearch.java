// import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int targetValue = 50;

        int index = binarySearch(sortedArray, targetValue);

        if (index != -1) {
            System.out.println("Element " + targetValue + " found at index " + index);
        } else {
            System.out.println("Element " + targetValue + " not found in the array");
        }
    }

    static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; 
            } else if (array[mid] < target) {
                left = mid + 1; 
            } else {
                right = mid - 1;
            }
        }

        return -1; 
    }
}
