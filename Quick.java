import java.util.Random;
import java.util.Arrays;

public class Quick{
  /*return the value that is the kth smallest value of the array.
  //should make better by not randomizing the number
 */
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
   int[] yea = new int[]{
     4, 3, 5, 6, 9, 10, 34, 8, 7, 20 , 23, 13, 45, 40, 2
   };
   int[] nah = new int[]{
     1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0
   };
   //System.out.println(Arrays.toString(nah));
   //System.out.println(partition(nah, 0, nah.length - 1));
   //System.out.println(Arrays.toString(nah));
   System.out.println(Arrays.toString(nah));
   System.out.println(quickselect(nah, 5));
   System.out.println(Arrays.toString(nah));
 }
}
