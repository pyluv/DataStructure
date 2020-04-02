package sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Classname BubbleSort
 * @Description TODO
 * @Date 4/2/2020 5:27 PM
 * @Created by Administrator
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {9, -6, 2, 78, 3};
//        sort(arr);
//        System.out.println(Arrays.toString(arr));
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
        int temp;
        boolean flag;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag = false) {
                break;
            } else flag = false; //重置flag。进行下次判断
        }
    }
}
