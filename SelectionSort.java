import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the size of array");
       int n= sc.nextInt();
       int min =0;
       int arr[] = new int[n];
       System.out.println("Enter the number of elements in the array: ");
       for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
       }
       System.out.println("Original array: ");
       for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
        System.out.println();
        for(int i=0;i<n;i++){
            min= i;
            for(int j=i+1;j<n;j++){
                  if(arr[j]<arr[min]) {
                    min = j;
            }
        }
        int temp = arr[min];
        arr[min] = arr[i];
        arr[i]= temp;
       sc.close();
    }
    System.out.println("Sorted array is:");
    for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
}     
}
}