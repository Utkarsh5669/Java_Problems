import java.util.*;
public class MergeSorting {
 
    public static void MergeSort(int[] array, int low, int high){
           if(low>=high)
           return;
           int mid = (low+high)/2;
           MergeSort(array, low, mid);
           MergeSort(array, mid+1, high);
           Merge(array,low,mid,high);
 
    }
    public static void Merge(int arr[], int low, int mid, int high){
             ArrayList<Integer> temp = new ArrayList<>();
             int left = low;
             int right = mid + 1;

             while(left<=mid && right<=high){
                if(arr[left]<arr[right]){
                    temp.add(arr[left]);
                    left++;
                }
                else{
                    temp.add(arr[right]);
                    right++;
                }
             }
             while(left<=mid){
                temp.add(arr[left]);
                left++;
             }
             while(right<=high){
                temp.add(arr[right]);
                right++;
             }

             for(int i=low;i<=high;i++){
                arr[i]=temp.get(i-low);
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
          MergeSort(arr, 0, n-1);
          for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
          }
         sc.close();
    }
    
}