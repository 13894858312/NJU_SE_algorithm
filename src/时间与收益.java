import java.util.Comparator;
import java.util.Scanner;

import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

/**
 * Created by wangxue on 2019/11/28.
 */
//todo
public class 时间与收益 {
//    贪婪算法 https://www.geeksforgeeks.org/job-sequencing-using-disjoint-set-union/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            int n = scanner.nextInt();
            Job[] job=new Job[n];
            for(int i = 0 ; i < n ; i ++){
                scanner.nextInt();
                int ddl = scanner.nextInt();
                int pro = scanner.nextInt();
                job[i] = new Job(ddl, pro);
            }

            func(n, job);
        }
    }

    static class Job {
        int ddl, pro;
        Job(int ddl, int pro) {
            this.ddl = ddl;
            this.pro=pro;
        }
    }

    private static void func(int n, Job[] job){

        sort(job, new Comparator<Job>(){
            public int compare(Job j1, Job j2) {
                return (j2.pro-j1.pro);
            }
        });

        boolean[] slot=new boolean[n];
        int[] res=new int[n];
        fill(slot, false);

        int ct=0, prof=0;
        for(int i=0; i<n; i++) {
            for(int j = Math.min(job[i].ddl, n) - 1 ; j>=0; j--) {
                if(!slot[j]) {
                    slot[j]=true;
                    res[j]=i;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(slot[i]) {
                ct++;
                prof += job[res[i]].pro;
            }
        }

        System.out.println(ct +" "+ prof);
    }
}
