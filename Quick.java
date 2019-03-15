import java.util.Random;
import java.util.Arrays;

public class Quick{
  /*return the value that is the kth smallest value of the array.
  //should make better by not randomizing the number
 */

 public static void quicksort(int[] data){
   qsorth(data, 0, data.length - 1);
 }

 public static void qsorth(int[] data, int lo, int hi){
  if(lo >= hi){
    return;
  }
  int pivot = partition(data, lo, hi);
  qsorth(data, lo, pivot - 1);
  qsorth(data, pivot + 1, hi);
 }




 public static int quickselect(int []data, int k){
   int end = data.length - 1;
   return qsh(data, k, 0, end);
 }

 public static int qsh(int[] data, int k, int start, int end){
   int a = partition(data, start, end);
   System.out.println(a);
   if(a > k - 1){
     return qsh(data, k, start, a);
   }
   if(a < k - 1){
     return qsh(data, k, a, end);
   }
   return data[a];
 }

 ///optimization1 pivot become median of the three values: hi lo and middle
 ///optimization2 duplicates have 50% to go to either side
 ///finish optimization1 and optimization2 by thursday

 public static int partition(int[] data, int start, int end){
   int middle = (start + end) / 2;
   int index = middle;
   if(data[start] > data[end] && data[start] < data[middle]
   || data[start] < data[end] && data[start] > data[middle]){
     index = start;
   }
   if(data[end] > data[start] && data[end] < data[middle]
   || data[end] < data[start] && data[end] > data[middle]){
     index = end;
   }
   int pivot = data[index];
   int temp = data[start];
   data[start] = pivot;
   data[index] = temp;
   index = start;
   start++;
   while (start != end) {
     if (data[start] > pivot
     || (data[start] == pivot && Math.random() > 0.50)){
       int temp2 = data[start];
       data[start] = data[end];
       data[end] = temp2;
       end--;
     }
     else {
       start++;
     }
   }
   if (data[index] < data[start]){
     start--;
   }
   int a = data[start];
   data[index] = a;
   data[start] = pivot;
   int b = -1;
   for(int i = start; i <= end; i++){
     if(data[i] == pivot){
       b = i;
     }
   }
   //System.out.println(pivot);
   return b;
 }
 public static int[] partitionDutch(int[] data, int lo, int hi){
   int middle = (lo + hi) / 2;
   int index = middle;
   if(data[lo] > data[hi] && data[lo] < data[middle]
   || data[lo] < data[hi] && data[lo] > data[middle]){
     index = lo;
   }
   if(data[hi] > data[lo] && data[hi] < data[middle]
   || data[hi] < data[lo] && data[hi] > data[middle]){
     index = hi;
   }
   int lt = lo;
   int gt = hi;
   int i = lt;
   int pivot = data[index];
   int temp = data[lo];
   data[lt] = pivot;
   data[index] = temp;
   index = lt;
   lt++;
   while (i <= gt) {
     if (data[i] > pivot){
       //switches gt value with lt value
       int temp1 = data[i];
       data[i] = data[gt];
       data[gt] = temp1;
       gt--;
     }
     else if(data[i] == pivot){
       //increments i
       i++;
     }
     else{
       int temp2 = data[i];
       data[i] = data[lt];
       data[lt] = temp2;
       lt++;
       i++;
     }
   }
   lt--;
   //swaps pivot with gt
   int temp3 = data[index];
   data[index] = data[lt];
   data[lt] = temp3;
   int[] yep = new int[]{
     lt, gt
   };
   System.out.println(pivot);
   return yep;
 }



 public static void main(String[]args){
  /*System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }*/

  int[] yea = new int[]{
    3,3,4,5,6,4,6,8,5,2,4,6,8,3,4,6,98,64,35,76,3,45,65,7
  };
  System.out.println(Arrays.toString(yea));
  System.out.println(Arrays.toString(partitionDutch(yea, 0, yea.length - 1)));
  System.out.println(Arrays.toString(yea));
}


}
