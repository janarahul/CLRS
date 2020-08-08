import java.util.*;
import java.io.*;
import java.util.stream.*;

class maxObject  implements Comparable<maxObject>{
int lp,rp,sum;
  maxObject(int lp,int rp,int sum){
    this.lp = lp;
    this.rp = rp;
    this.sum = sum;
  }
  public String toString(){
    return "["+lp+", "+rp+", "+sum+"]";
  }
  public int compareTo(maxObject ob){
    if(sum == ob.sum)
      return 0;
    else if(sum > ob.sum)
      return 1;
    else
      return -1;
  }
}

class maxSubarray{
  public static maxObject findMaxCrossing(int arr[],int l,int m, int h){
    int i=0,j=0,sum=0,lp=0,rp=0;
    int leftMax = Integer.MIN_VALUE;
    int rightMax = Integer.MIN_VALUE;
    for(i=m;i>=l;i--){
      sum = sum+arr[i];
      if(sum > leftMax){
        leftMax = sum;
        lp = i;
      }
    }
    sum =0;
    for(j=m+1;j<=h;j++){
      sum = sum+arr[j];
      if(sum > rightMax){
        rightMax = sum;
        rp = j;
      }
    }
    return new maxObject(lp,rp,leftMax+rightMax);
  }

  public static maxObject findMaxSubarray(int arr[], int l, int h){
    if (l==h){
      return new maxObject(l,h,arr[l]);
    }
    int mid = (l + h )/2;
    List<maxObject> mos= new ArrayList<maxObject>();
    mos.add(findMaxSubarray(arr,l,mid));
    mos.add(findMaxSubarray(arr,mid+1,h));
    mos.add(findMaxCrossing(arr,l,mid,h));
    Collections.sort(mos);
    return mos.get(mos.size()-1);

  }

  public static maxObject kadaneAlgo(int arr[],int l,int h){
    int max_so_far = Integer.MIN_VALUE, global_max = Integer.MIN_VALUE;
    int temp_left =0, temp_right = 0, global_left =0, global_right =0;
    int i=0;
    temp_left = l;
    for(i=l;i<=h;i++){
      if(max_so_far > 0){
        max_so_far = max_so_far + arr[i];
        temp_right = i;
      }else{
        max_so_far = arr[i];
        temp_left = i;
        temp_right = i;
      }
      if(max_so_far > global_max){
        global_max = max_so_far;
        global_left = temp_left;
        global_right = temp_right;
      }

    }
    return new maxObject(global_left,global_right,global_max);
  }

    public static void main(String args[]) throws IOException {
      BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter numbers: space sepearated");
      String line = bw.readLine();
      int arr[] = Stream.of(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      System.out.println(findMaxSubarray(arr,0,arr.length -1));
      System.out.println(kadaneAlgo(arr,0,arr.length -1));

    }
}