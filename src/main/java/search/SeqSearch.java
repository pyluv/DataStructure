package search;

/**
 * @Classname SeqSearch
 * @Description TODO
 * @Date 4/3/2020 10:27 AM
 * @Created by Administrator
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1,3,1,4};

        int index = search(arr, 3);
        if (index == -1) {
            System.out.println("cannot find the value");
        }else System.out.println(index);
    }

    public static int search(int[] arr,int value) {
        for(int i =0;i<arr.length;i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;

    }

}

