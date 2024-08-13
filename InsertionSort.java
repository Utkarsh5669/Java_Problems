import java.util.*;
public class InsertionSort {

    public void insertionSort(int arr[], int n){
        for(int i=0; i<=n-1; i++){
            int j=i;
        while(j>0 && arr[j-1]>arr[j]){
            int temp = arr[j-1];
            arr[j-1] = arr[j];
            arr[j] = temp;
            j--;
        }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
      int n = sc.nextInt();
      int arr[] = new int[n];
      System.out.println("Enter the elements of the array");
      for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
      }
      System.out.println("Array before sorting");
      for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
      }
      System.out.println();
      System.out.println("Array after sorting");
      InsertionSort is = new InsertionSort();
      is.insertionSort(arr, n);
      for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
      sc.close();
    }
    
}
