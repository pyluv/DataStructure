package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @Classname InsertSort
 * @Description TODO
 * @Date 4/2/2020 7:42 PM
 * @Created by Administrator
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long timestamp1 = System.currentTimeMillis();
        String result1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp1);
        System.out.println(timestamp1);
        sort(arr);
        long timestamp2 = System.currentTimeMillis();
        String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp2);
        System.out.println(timestamp2);
    }

    public static void sort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用for循环来把代码简化
        for(int i = 1; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

            //System.out.println("第"+i+"轮插入");
            //System.out.println(Arrays.toString(arr));
        }
    }
}

