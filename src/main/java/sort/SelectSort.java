package sort;

import java.text.SimpleDateFormat;

/**
 * @Classname SelectSort
 * @Description TODO
 * @Date 4/2/2020 6:13 PM
 * @Created by Administrator
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long timestamp1 = System.currentTimeMillis();
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp1);
        System.out.println("Date:" + result1);
        sort(arr);
        long timestamp2 = System.currentTimeMillis();
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp2);
        System.out.println("Date:" + result2);
    }
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }

            // 将最小值，放在arr[0], 即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }

    }
}
