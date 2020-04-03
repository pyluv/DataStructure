package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname InsertValueSearch
 * @Description TODO
 * @Date 4/3/2020 11:28 AM
 * @Created by Administrator
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int [] arr = new int[100];

        for (int i = 0; i <100; i ++) {
            arr[i] = i;
        }
        List indexList = search(arr,0,arr.length-1,1) ;

        System.out.println(indexList);

    }

    public static ArrayList<Integer> search(int[] arr, int left, int right, int value) {
        ArrayList<Integer> resIndexList = new ArrayList<Integer>();
        while (left <= right) {
            int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
            if (value > arr[mid]) {
                left = mid + 1;
                return search(arr, left, right, value);
            } else if (value < arr[mid]) {
                right = mid - 1;
                return search(arr, left, right, value);
            } else {
                int tmp = mid -1;
                while (true) {
                    if (tmp < 0 || arr[tmp] != value) {
                        break;
                    }

                    resIndexList.add(tmp);
                    tmp --;
                }
                tmp = mid +1;
                while (true){
                    if (tmp > arr.length -1 || arr[tmp] != value) {
                        break;
                    }
                    resIndexList.add(tmp);
                    tmp ++;
                }
                resIndexList.add(mid);
                return resIndexList;
            }
        }
        resIndexList.add(-1);
        return resIndexList;
    }
}
