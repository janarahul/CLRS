import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

class QuickSort{

    public static void exchange(int[] A,int i,int j){
        if(i!= j){   
            A[i] = A[i] + A[j];
            A[j] = A[i] - A[j];
            A[i] = A[i] - A[j];
        }
    }

    public static int partition(int[] A,int p, int r){
        int i = p-1;
        for(int j=p;j<=r-1;j++){
            if(A[j]<= A[r]){
                i = i+1;
                exchange(A,j,i);
            } 
        }
        exchange(A,r,i+1);
        return i+1;
    }
    public static int randomPartition(int[] A,int p, int r){
        int randomIndex = ThreadLocalRandom.current().nextInt(p,r+1);
        exchange(A,r,randomIndex);
        return partition(A,p,r);
    }
    public static int[] partitionModified(int[] A,int p, int r){
        int x = A[p];
        int low = p;
        int high = p;
        int y;
        for (int j = p + 1;j<=r;j++){
            if (A[j] < x){
                y = A[j];
                A[j] = A[high + 1];
                A[high + 1] = A[low];
                A[low] = y;
                low = low + 1;
                high = high + 1;
            }else if (A[j] == x){
                exchange (A,high+1,j);
                high = high + 1;
            }
        }
        return new int[]{low, high};
    }

    public static void quickSortAlgo(int[] A,int p,int r){
        if (p < r){
            int q = partition(A,p,r);
            quickSortAlgo(A,p,q-1);
            quickSortAlgo(A,q+1,r);
        } 
    }
    public static void modifiedQuickSortAlgo(int[] A,int p,int r){
        if (p < r){
            int[] pivot = partitionModified(A,p,r);
            quickSortAlgo(A,p,pivot[0]-1);
            quickSortAlgo(A,pivot[1]+1,r);
        } 
    }
    public static void randomizedQuickSortAlgo(int[] A,int p,int r){
        if (p < r){
            int q = randomPartition(A,p,r);
            randomizedQuickSortAlgo(A,p,q-1);
            randomizedQuickSortAlgo(A,q+1,r);
        } 
    }
    public static void tailRecursiveQuickSortAlgo(int[] A,int p,int r){
        while (p < r){
            int q = randomPartition(A,p,r);
            tailRecursiveQuickSortAlgo(A,p,q-1);
            p = q+1;
        } 
    }
    public static void modifiedTailRecursiveQuickSortAlgo(int[] A,int p,int r){
        while (p < r){
            int q = randomPartition(A,p,r);
            if(q < (p+r)/2){
                tailRecursiveQuickSortAlgo(A,p,q-1);
                p = q+1;
            }else{
                tailRecursiveQuickSortAlgo(A,q+1,r);
                r = q-1;
            }
        } 
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number to sort space seperated");
        int[] input_arr = Stream.of(bw.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        modifiedQuickSortAlgo(input_arr,0,input_arr.length-1);
        System.out.println(Arrays.toString(input_arr));
    }  
}