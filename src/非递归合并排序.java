import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/27.
 */
//todo
public class 非递归合并排序 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                arrayList.add(s.nextInt());
            }

            int l = arrayList.size();
            Integer[] array = arrayList.toArray(new Integer[l]);

            func(array);
            for(int i = 0 ; i < array.length ; i ++){
                if(i==array.length-1){
                    System.out.println(array[i]);
                    continue;
                }
                System.out.print(array[i] + " ");
            }
        }
    }

    public static void func(Integer[] arr) {
        int len = arr.length;
        int k = 1;

        while(k < len) {
            mergePass(arr, k, len);
            k *= 2;
        }
    }

    private static void mergePass(Integer[] arr, int k, int n) {
        int i = 0;

        while(i < n - 2*k + 1) {
            merge(arr, i, i + k-1, i + 2*k - 1);
            i += 2*k;
        }

        if(i < n - k ) {
            merge(arr, i, i+k-1, n-1);
        }

    }

    private static void merge(Integer[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid+1;
        int k = 0;

        for(; i <= mid && j <= high; k++){
            if(arr[i] < arr[j]) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= high) {
            temp[k++] = arr[j++];
        }
        for(int l = 0; l < temp.length; l++){
            arr[low + l] = temp[l];
        }
    }
}
