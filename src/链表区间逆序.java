import java.util.Scanner;

/**
 * Created by wangxue on 2019/10/27.
 */
//自己写的，不准
public class 链表区间逆序 {
    static class MyList{
        MyList next = null;
        String c;
        MyList(String c){
            this.c = c;
        }
        boolean hasNext(){
            return this.next!=null;
        }
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i = 0 ; i < t ; i ++){
            int n = s.nextInt();

            MyList head = new MyList(s.next());
            MyList front = head;
            for(int j = 1 ; j < n ; j ++){
                String c = s.next();
                MyList node = new MyList(c);
                front.next = node;
                front = node;
            }

            int k = s.nextInt();
            MyList a = head;

            if(n/k > 0){
                for(int j = 1 ; j < k ; j ++){
                    head = head.next;
                }
            }



            for(int j = 0; j < n/k ; j++){

                if(j>0){
                    MyList tt = a;
                    for(int z = 0 ; z < k ; z++){
                        tt = tt.next;
                    }
                    MyList e = a.next;
                    a.next = tt;
                    a = e;
                }

                MyList[] lists = new MyList[k];
                for(int z = 0 ; z < k ; z ++){
                    if(z == 0){
                        lists[z] = a;
                    }else{
                        lists[z] = lists[z-1].next;
                    }
                }

                a.next = lists[k-1].next;

                for(int z = 1 ; z < k ; z ++){
                    lists[z].next = lists[z-1];
                }
            }

            MyList node = head;
            while(true){
                if(node.hasNext()){
                    System.out.print(node.c + " ");
                    node = node.next;
                }else {
                    System.out.print(node.c);
                    break;
                }
            }
            System.out.println();

        }
    }

}
