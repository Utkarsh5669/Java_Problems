import java.util.*;
public class BubbleSort{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the size of array");
       int n= sc.nextInt();
       int temp =0;
       int arr[] = new int[n];
       System.out.println("Enter the number of elements in the array: ");
       for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
       }
       System.out.println("Original array: ");
       for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                     temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
            }
        }
       
    }
    System.out.println();
    System.out.println("Sorted array: ");
    for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
    }

sc.close();
}
}
