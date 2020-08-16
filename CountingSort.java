import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

class CountingSort{

    // Runs in big-theta(n+k)
    public static int[] CountingSortAlgo(int[] A,int k){
        int[] helper_arr = new int[k+1];
        int[] output = new int[A.length];

        for(int i=0;i<=k;i++){
            helper_arr[i] = 0;
        }
        for(int j=0;j<A.length;j++){
            helper_arr[A[j]] = helper_arr[A[j]] + 1;
        }
        for(int i =1;i<=k;i++){
            helper_arr[i] = helper_arr[i] + helper_arr[i-1];
        }
        for(int j=A.length-1;j>=0;j--){
            output[helper_arr[A[j]]-1] = A[j]; //-1 as arrays start at 0
            helper_arr[A[j]] = helper_arr[A[j]] -1;
        }
        return output;
    }
    
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter max number in the input");
        int k = sc.nextInt();
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers to sort: space seperated");
        int[] input_arr = Stream.of(bw.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println("Sorted array:"+Arrays.toString(CountingSortAlgo(input_arr,k)));
    }  
}