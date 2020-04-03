package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname BinarySearch
 * @Description TODO
 * @Date 4/3/2020 10:39 AM
 * @Created by Administrator
 */
public class BinarySearch {
    //二分查找的前提是数组有序
    public static void main(String[] args) {
        int[] arr = {1, 1, 1,1,2};
//        int index = search(arr, 0, arr.length - 1, 66);
//        System.out.println(index);
        List indexList = searchDuplicated(arr, 0, arr.length - 1, 1);
        System.out.println(indexList);

    }

    public static int search(int[] arr, int left, int right, int value) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value > arr[mid]) {
                left = mid + 1;
                return search(arr, left, right, value);
            } else if (value < arr[mid]) {
                right = mid - 1;
                return search(arr, left, right, value);
            } else {

                return mid;
            }
        }
        return -1;
    }

    public static ArrayList<Integer> searchDuplicated(int[] arr, int left, int right, int value) {
        ArrayList<Integer> resIndexList = new ArrayList<Integer>();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value > arr[mid]) {
                left = mid + 1;
                return searchDuplicated(arr, left, right, value);
            } else if (value < arr[mid]) {
                right = mid - 1;
                return searchDuplicated(arr, left, right, value);
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
