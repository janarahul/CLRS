import java.util.*;
import java.util.stream.*;
import java.io.*;



class Heap{
    ArrayList<Integer> heap;

    Heap(List<Integer> list){
        this.heap = new ArrayList<>(list);
        buildHeap();
    }

    int left(int index){
        return 2*index;
    }

    int right(int index){
        return (2*index) +1;
    }

    int parent(int index){
        return index/2;
    }

    void exchange(int i,int j){
        Integer a = heap.get(i);
        Integer b = heap.get(j);
        heap.set(i,b);
        heap.set(j,a);
    }

    public void maxHeapify(int index,int heapSize){
        int l = left(index);
        int r = right(index);
        int largest = index;

        if(l < heapSize && heap.get(l) > heap.get(index)){
            largest = l;
        }
        if(r < heapSize && heap.get(r) > heap.get(largest)){
            largest = r;
        }
        if(largest != index){
            exchange(index,largest);
            maxHeapify(largest,heapSize);
        }
    }

    public void buildHeap(){
        int heapSize = heap.size();
        for(int i=(heapSize/2);i>0;i--){
            maxHeapify(i,heapSize);
        }
    }

    public void sort(){
        buildHeap();
        for(int i=(heap.size())-1;i>1;i--){
            exchange(i,1);
            maxHeapify(1,i);
        }
    }

    public int maximum(){
        return heap.get(1); 
    }

    public int extractMaximum(){
        int max = maximum();
        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        maxHeapify(1,heap.size()-1);
        return max;
    }

    public void increaseKey(int i,int key){
        if (key < heap.get(i)){
            System.out.println("Value is lower than current value");
        }else{
            heap.set(i,key);
            while(parent(i) >= 1 && heap.get(i)>heap.get(parent(i))){
                exchange(i,parent(i));
                i = parent(i);
            }
        }
    }

    public void insertKey(int key){
        heap.add(Integer.MIN_VALUE);
        increaseKey(heap.size()-1,key);
    }

    public String toString(){
        return heap.toString();
    }
}

class HeapSort{

    public static void main(String args[]) throws IOException {
        Heap myHeap = new Heap(Arrays.asList(Integer.MIN_VALUE,6,2,7,4,5,11));
        System.out.println(myHeap.toString());
        myHeap.increaseKey(1,18);
        System.out.println(myHeap.toString());
        myHeap.insertKey(11);
        System.out.println(myHeap.toString());
        myHeap.sort();
        System.out.println(myHeap.toString());
    }  
}