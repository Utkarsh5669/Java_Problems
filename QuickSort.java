import java.util.*;
public class QuickSort {
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low]; 
        int i = low + 1;  
        int j = high;

        while (i <= j) {
            
            while (i <= j && array[i] <= pivot) {
                i++;
            }
            while (i <= j && array[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;  
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n= sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements os array");
        for( int i=0;i<n;i++){
            array[i]= sc.nextInt();
        }

        System.out.println("Unsorted array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println("Sorted array:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
