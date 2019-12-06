import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/27.
 */
//https://practice.geeksforgeeks.org/problems/recurrence-matrix/0
//    todo 还没看
public class 矩阵计算 {
    public static void main (String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int n=scanner.nextInt();
            int count=0;
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {

                    int temp=(i*j)%7;
                    temp=(temp*temp*temp)%7;

                    if(temp==2||temp==3||temp==4||temp==6||temp==0)
                        count++;

                }
            }
            System.out.println(count);

        }
    }

}
