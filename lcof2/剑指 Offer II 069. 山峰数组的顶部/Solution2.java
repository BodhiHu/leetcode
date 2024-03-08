import java.util.Arrays;

public class Solution2 {
  public static int peakIndex(int[] arr) {
    int peak = -1;
    for (int i = 1; i < (arr.length - 1); i++) {
      if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
        return peak;
      }
    }

    return peak;
  }

  public static int peakIndexBinarySearch(int[] arr) {
    // [ 0, 1, 2, 3, 4, 5 ]
    System.out.println("Inputs = " + Arrays.toString(arr));
    int startIdx = 0, endIdx = arr.length - 1;
    while(true) {
      int midIdx = (startIdx + endIdx) / 2;
      if (arr[midIdx] > arr[midIdx-1] && arr[midIdx] > arr[midIdx+1]) {
        System.out.println(midIdx + ", " + arr[midIdx]);
        return midIdx;
      }

      if (midIdx == startIdx || midIdx == endIdx) {
        System.out.println("-1");
        return -1;
      }

      if (arr[midIdx] > arr[midIdx-1] && arr[midIdx] < arr[midIdx+1]) {
        startIdx = midIdx;
      } else {
        endIdx = midIdx;
      }
    }
  }

  public static void main(String[] args) {
    peakIndexBinarySearch(new int[]{0,1,0});
    peakIndexBinarySearch(new int[]{1,3,5,4,2});
    peakIndexBinarySearch(new int[]{24,69,100,99,79,78,67,36,26,19});
  }
}
