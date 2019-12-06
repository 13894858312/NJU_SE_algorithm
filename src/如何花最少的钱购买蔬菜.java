import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/21.
 */
//todo dp https://practice.geeksforgeeks.org/editorial.php?pid=3112
// 这是一个基于动态编程的非常简单的问题。在这里，我们只需要考虑如何使用直到第（i-1）个蔬菜卖方的所有蔬菜卖方的答案计算到第i个蔬菜卖方的蔬菜的最低价格。由于不能从相邻的蔬菜销售商那里购买相同的蔬菜，即如果我们从i商店购买茄子，我们就不能从i + 1和i-1商店购买茄子。胡萝卜和西红柿也是如此。如果我们从每个商店购买每种蔬菜，我们将简单地找到最低的成本。因此，dp [i] [j]表示从第i家商店购买第j种蔬菜的最低购物成本（仅考虑到第i家商店）。最后，对于i = n和j = 0,1,2，取最小值dp [i] [j]，因为它将考虑
//    github↓
//    有坑？
public class 如何花最少的钱购买蔬菜 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while(caseNum-- >0){
            int inputLen = Integer.parseInt(cin.nextLine().trim());
            int[][] inArr = new int[inputLen][3];
            for(int i=0;i<inputLen;i++)
                inArr[i] = StringarrToIntarr(cin.nextLine().trim());


            int[][] DP = new int[inputLen][3];
            for(int j=0;j<3;j++)
                DP[0][j] = inArr[0][j];

            for(int i=1;i<inputLen;i++)
                for(int j=0;j<3;j++)
                    DP[i][j] = Math.min( DP[i-1][(j+1)%3] , DP[i-1][(j+2)%3] ) + inArr[i][j];

            int minResult = Integer.MAX_VALUE;
            for(int j=0;j<3;j++)
                minResult = Math.min(minResult,DP[inputLen-1][j]);

            System.out.printf("%d\n",minResult);
        }
    }
    public static int[] StringarrToIntarr(String string) {
        String[] inputS = string.split(" ");
        int[] output = new int[inputS.length];
        for (int j = 0; j < inputS.length; j++) {
            output[j] = Integer.parseInt(inputS[j]);
        }
        return output;
    }
    }
