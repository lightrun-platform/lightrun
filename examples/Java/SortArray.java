import java.util.Random;

public class SortArray { 
  public static int[] fillArr() {
    int[] arr = new int[10];
    Random rand = new Random();
    for (int i = 0; i < 10; i++) {
      arr[i] = rand.nextInt(100) + 1;
    }
    return arr;
  }

  public static int[] sortArr(int[] arr) {
    int swaps = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
          swaps ++;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    while (true) {
      int[] arr = fillArr();
      System.out.println("Original array:");
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      int[] sortedArr = sortArr(arr);
      System.out.println("Sorted array:");
      for (int i = 0; i < sortedArr.length; i++) {
        System.out.print(sortedArr[i] + " ");
      }
      System.out.println();
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
      }
      
    }
  }
}
