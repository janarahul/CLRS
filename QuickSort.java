import java.util.*;
import java.util.stream.*;
import java.io.*;

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
    public static void quickSortAlgo(int[] A,int p,int r){
        if (p < r){
            int q = partition(A,p,r);
            quickSortAlgo(A,p,q-1);
            quickSortAlgo(A,q+1,r);
        } 
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter number to sort space seperated");
        int[] input_arr = Stream.of(bw.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        quickSortAlgo(input_arr,0,input_arr.length-1);
        System.out.println(Arrays.toString(input_arr));
    }  
}