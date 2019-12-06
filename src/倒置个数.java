import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/26.
 */
//todo
public class 倒置个数 {
//    利用归并排序的特性，当右边更小的数s[q]被加入空间T时，左边剩余的数都可以与该数组成逆序对，因而直接将总逆序对数加上左边剩余的数即可得到结果

    private static int[] array;
    private static int count;

    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while (t --> 0){
            count = 0;
            int n = s.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = s.nextInt();
            }

            //处理
            func(0, n);
            System.out.println(count);
        }
    }

//    左闭右开
    private static void func(int left, int right) {
        if(right - left > 1){
            int m = left + (right-left)/2;
            func(left, m);//计算left逆序对并归并排序
            func(m, right);//计算right逆序对并归并排序

            int[] t = new int[1000];
            int p = left;
            int q = m;
            int countn = 0;

            while (p<m || q<right){//只要其中任意一个未到尽头就可以继续排序

                if(p >= m || ( q<right && p<m && array[q]<array[p] ) ){//若左边到头或左右都没到头但右边更小，则将右边加入临时空间
                    t[countn++] = array[q++];
                    count += m-p;//计算逆序对和归并排序只差了这一步
                }else {
                    t[countn++] = array[p++];
                }
            }
            //临时空间T复制到原始空间s
            for(int i = 0 ; i < countn ; i ++){
                array[left+i] = t[i];
            }
        }
    }

}
