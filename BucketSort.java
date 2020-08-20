import java.util.*;
import java.util.stream.*;
import java.io.*;

class BucketSort{

    public static ArrayList<Double> BucketSortAlgo(double[] A){
        int n = A.length;
        ArrayList<ArrayList<Double>> B = new ArrayList<ArrayList<Double>>(n);
        for(int i=0;i<n;i++){
            B.add(i,new ArrayList<Double>());
        }
        ArrayList<Double> output = new ArrayList<Double>();
        for(int i=0;i<n;i++){
            B.get((int)Math.floor(A[i]/(double)n)).add(A[i]);
        }
        for(int i=0;i<n;i++){
            Collections.sort(B.get(i));
        }
        for(int i=0;i<n;i++){
            output.addAll(B.get(i));
        }
        return output;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numbers to sort: space seperated within the range[0,1)");
        double[] input_arr = Stream.of(bw.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        BucketSortAlgo(input_arr);
        System.out.println("Sorted array:"+BucketSortAlgo(input_arr));
    }  
}