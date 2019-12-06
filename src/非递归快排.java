import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangxue on 2019/10/27.
 */
//todo
public class 非递归快排 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int n = s.nextInt();
            ArrayList<Integer> arrayList = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                arrayList.add(s.nextInt());
            }
            func(0, arrayList.size()-1 ,arrayList);
            for(int i = 0 ; i < arrayList.size() ; i ++){
                if(i==arrayList.size()-1){
                    System.out.println(arrayList.get(i));
                    continue;
                }
                System.out.print(arrayList.get(i) + " ");
            }
        }
    }

//    用栈代替递归
    private static void func(int low, int high, ArrayList<Integer> arrayList){
        Stack<Integer> stack = new Stack<>();

        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();

            if(low >= high){
                continue;
            }
            int l = low;
            int r = high;

            int now = arrayList.get(low);
            while(low < high){
                while(low<high && arrayList.get(high) >= now){
                    high --;
                }
                int t = arrayList.get(high);
                arrayList.set(high, arrayList.get(low));
                arrayList.set(low, t);
                while(low < high && arrayList.get(low) <= now){
                    low ++;
                }
                t = arrayList.get(high);
                arrayList.set(high, arrayList.get(low));
                arrayList.set(low, t);
            }
            stack.push(l);
            stack.push(low-1);
            stack.push(low+1);
            stack.push(r);
        }

    }

    //递归快排
    private static int part(int low, int high, int[] array){
        int now = array[low];
        while(low<high){
            while(low<high && array[high] >= now){
                high --;
            }
            int t = array[high];
            array[high] = array[low];
            array[low] = t;
            while(low < high && array[low] <= now){
                low ++;
            }
            t = array[high];
            array[high] = array[low];
            array[low] = t;
        }
        return low;
    }
}
