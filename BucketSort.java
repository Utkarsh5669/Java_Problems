import  java.util.*;
public class BucketSort {
    public static void bucketSort(int arr[] , int n, int k){
        int max = arr[0];
        for(int i=0;i<n;i++){
            max = Math.max(max, arr[i]);
        } 
        max++;

        ArrayList<ArrayList<Integer> > buckets = new ArrayList<>();

        for(int i =0 ;i<n;i++){
             // buckets.add(new ArrayList<>());
            ArrayList<Integer> temp = new ArrayList<>();
            buckets.add(temp);
        }

        for(int i =0;i<n;i++){
            int Bucketindex = ((arr[i] *k )/ max );
            buckets.get((int)Bucketindex).add(arr[i]);
        }

        for(int i=0;i<k;i++){
            Collections.sort(buckets.get(i));
        }
         int index=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<buckets.get(i).size();j++){
                arr[index++]=buckets.get(i).get(j);

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
          bucketSort(arr,n,4);
          for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
          }
            sc.close();

        }
    }
    

