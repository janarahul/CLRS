import java.util.*;
import java.io.*;
import java.util.stream.*;
class MedianFinder {
    PriorityQueue<Integer> min_heap;
    PriorityQueue<Integer> max_heap;

    public MedianFinder() {
        this.min_heap = new PriorityQueue<Integer>();
        this.max_heap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max_heap.add(num);
        min_heap.add(max_heap.peek());
        max_heap.poll();
        if(min_heap.size() >= max_heap.size()+1){
            max_heap.add(min_heap.poll());
        }
    }
    
    public Double findMedian() {
        return (max_heap.size() > min_heap.size()) ? max_heap.peek().doubleValue() : ((max_heap.peek() + min_heap.peek()) * 0.5);
    }
    public static void main(String args[]) throws IOException {
        MedianFinder obj = new MedianFinder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] arr = Stream.of(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<arr.length;i++){
            obj.addNum(arr[i]);
            System.out.println(obj.findMedian());
        }
    }
}
