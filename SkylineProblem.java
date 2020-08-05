import java.util.*;
import java.io.*;
import java.util.stream.*; 
/* ######################
Each building is of the form [left,ht,right]
Each skyline strip represented by [left,ht]

Input is a series of buildings
Output is series of skylines

###################### */
class InputError extends Exception {

}
class Skyline{
  int lt;
  int ht;
  Skyline(int lt,int ht){
    this.lt = lt;
    this.ht = ht;
  }
  public String toString(){
    return "["+lt+","+ht+"]";
  }
}

class Building{
  int lt;
  int ht;
  int rt;
  Building(int lt,int ht,int rt){
    this.lt = lt;
    this.ht = ht;
    this.rt = rt;
  }
  public String toString(){
    return "["+lt+","+ht+","+rt+"]";
  }
}

class SkylineAlgo{
  public void append(List<Skyline> res, Skyline obj){
    int n = res.size();
    if (n >0){
      Skyline last = res.get(res.size()-1);
      if (last.ht == obj.ht) 
              return; 
          if (last.lt == obj.lt) 
          { 
              last.ht =Math.max(last.ht, obj.ht); 
              return; 
          } 
      }
        res.add(obj); 
  }
  public List<Skyline> mergeSkyLines(List<Skyline> res_l, List<Skyline> res_r){
    List<Skyline> res = new ArrayList<Skyline>();
    int ht_l = 0,ht_r = 0,i=0,j=0;
    while(i < res_l.size() && j < res_r.size()){
      if(res_l.get(i).lt < res_r.get(j).lt){
        int x = res_l.get(i).lt;
        ht_l = res_l.get(i).ht;
        int max_ht = Math.max(ht_l,ht_r);
        append(res,new Skyline(x,max_ht));
        i++;
      }
      else{
        int x = res_r.get(j).lt;
        ht_r = res_r.get(j).ht;
        int max_ht = Math.max(ht_l,ht_r);
        append(res,new Skyline(x,max_ht));
        j++;  
      }
    }
    while(i < res_l.size()){
      append(res,res_l.get(i));
      i++;
    }
    while(j < res_r.size()){
      append(res,res_r.get(j));
      j++;
    }
    return res;
  }
  public List<Skyline> findSkyLine(ArrayList<Building> arr,int p,int r){
    List<Skyline> res = new ArrayList<Skyline>(); 
    if (p == r){
      res.add(new Skyline(arr.get(p).lt,arr.get(p).ht));
      res.add(new Skyline(arr.get(p).rt,0));
      return res;
    }
    int q = (p+r)/2; 
    List<Skyline> res_l = findSkyLine(arr, p, q); 
    List<Skyline> res_r = findSkyLine(arr, q+1, r);
    res = mergeSkyLines(res_l,res_r);

    return res;
  }
}

class SkylineProblem{

    public static void main(String args[]) throws IOException,InputError {  
      Scanner scanner = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter no of Buildings");
      int noOfBuildings = scanner.nextInt();
      ArrayList<Building> blist = new ArrayList<Building>();
      String  line;    
      for(int i=0;i< noOfBuildings; i++){
        line = br.readLine();
        int[] arrs = Stream.of(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        if (arrs.length != 3){
          throw new InputError();
        }
        blist.add(new Building(arrs[0],arrs[1],arrs[2]));
      }
      
      SkylineAlgo sol = new SkylineAlgo();
      System.out.println(sol.findSkyLine(blist,0,blist.size()-1));
    }  
}  