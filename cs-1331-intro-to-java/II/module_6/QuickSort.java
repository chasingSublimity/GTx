import java.util.*;

public class QuickSort {
  public static int[] sort(int[] nums) {
    int currIdx = 0;
    
    while (currIdx < nums.length) {
      int minIdx = currIdx;
      for (int i = currIdx; i < nums.length; i++) {
        if (nums[i] < nums[minIdx]) {
          // update minIdx
          minIdx = i;
        }
        // swap
        int tmp = nums[currIdx];
        nums[currIdx] = nums[minIdx];
        nums[minIdx] = tmp;
      }
      currIdx++;
    }

    return nums;
  }

  public static void main(String[] args) {
    int[] arr = {4,6,7,9,1};
    int[] arr2 = {1,2,3};
    int[] arr3 = {3,2,1};
    
    System.out.println(Arrays.toString(sort(arr))); 
    System.out.println(Arrays.toString(sort(arr2))); 
    System.out.println(Arrays.toString(sort(arr3))); 
  }
}