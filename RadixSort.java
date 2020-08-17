import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

class RadixSort{

    public static int getMeNthElement(int number,int n){
        if(n == 1){
            return number%10; 
        }
        return getMeNthElement(number/10,n-1);
    }
    public static void CountingSort(int[] A,int n){
        int[] helper_arr = new int[10];
        int[] output = new int[A.length];

        for(int i=0;i<=9;i++){
            helper_arr[i] = 0;
        }
        for(int j=0;j<A.length;j++){
            helper_arr[getMeNthElement(A[j],n)] = helper_arr[getMeNthElement(A[j],n)] + 1;
        }
        for(int i =1;i<=9;i++){
            helper_arr[i] = helper_arr[i] + helper_arr[i-1];
        }

        for(int j=A.length-1;j>=0;j--){
            output[helper_arr[getMeNthElement(A[j],n)]-1] = A[j]; //-1 as arrays start at 0
            helper_arr[getMeNthElement(A[j],n)] = helper_arr[getMeNthElement(A[j],n)] -1;
        }
        System.arraycopy(output, 0, A, 0, A.length);
    }
    public static void RadixSortAlgo(int[] A,int d){
        for(int i=1;i<=d;i++){
            CountingSort(A,i);
        }
    }
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter max number of digits in a number");
        int d = sc.nextInt();
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers to sort: space seperated");
        int[] input_arr = Stream.of(bw.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        RadixSortAlgo(input_arr,d);
        System.out.println("Sorted array:"+Arrays.toString(input_arr));
    }  
}