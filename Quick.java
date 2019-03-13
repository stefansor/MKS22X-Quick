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

 public static int partition(int[] data, int start, int end){
   Random rng = new Random();
   int index = Math.abs(rng.nextInt(end - start)) + start;
   int pivot = data[index];
   int temp = data[start];
   data[start] = pivot;
   data[index] = temp;
   index = start;
   start++;
   while (start != end) {
     if (data[start] >= pivot){
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




 public static void main(String[] args){
   Random rng = new Random();
   int[] yea = new int[200000];
   int[] yea2 = new int[200000];
   for(int i = 0; i < yea.length; i++){
     int a = rng.nextInt();
     yea[i] = a;
     yea2[i] = a;
   }
   quicksort(yea);
   Arrays.sort(yea2);
   if(Arrays.equals(yea, yea2)){
     System.out.println("true");
   }
   System.out.println("false");
 }
}
