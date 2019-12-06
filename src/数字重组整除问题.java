import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/26.
 */
public class 数字重组整除问题 {
//    注意前导0
//    组合问题
//    坑：0不能被17整除
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-->0){
            String string = scanner.nextLine();
            ArrayList<String> res = new ArrayList<>();
            char[] c = string.toCharArray();
            findAllPermutations(0,string.length()-1,c,res);
            if(res.size()==0){
                System.out.println("Not Possible");
            }else {
                System.out.println(res.stream().max(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }).get());
            }
        }
    }

    private static void findAllPermutations(int l, int r,char[] s,ArrayList<String> res){
        if(l==r){
            String out = "";
            for(char c: s){
                out += c;
            }

            long num = Long.parseLong(out);
            if(num%17==0 && num!=0){
                res.add(out);
            }
            return;
        }

        for(int i=l;i<=r;i++){
            swap(s,l,i);
            findAllPermutations(l+1,r,s,res);
            swap(s,l,i);
        }
    }

    private static void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
