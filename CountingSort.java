import java.util.*;
public class CountingSort {
    
    static void countSort(int arr[] , int size){
       int output[] = new int[size+1]; 

        int max = arr[0];
        for(int i=1;i<size;i++)
        {
           if(arr[i]>max){
            max = arr[i];
           }
        }
        int count[] = new int[max+1];

        for(int i =0;i< max;i++){
            count[i]=0;
        }

        for(int i=0;i<size;i++){
            count[arr[i]]++;
        }

        for(int i =1;i<=max;i++){
            count[i]+=count[i-1];
        }

        for(int i=size-1;i>=0;i--){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        for(int i=0;i<size;i++){
            arr[i]=output[i];
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
        countSort(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
            }
        sc.close();
    }
}
