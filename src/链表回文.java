import java.util.Scanner;

/**
 * Created by wangxue on 2019/11/27.
 */
//todo 还没看
public class 链表回文 {
//    https://blog.csdn.net/weixin_33998125/article/details/92454858
//1、申请一个指针，从表头遍历至链表中间位置
//2、将原链表后半部分进行指针指向倒置，比如a->b->c变换为c->b->a（倒置思路见后文）
//3、然后类似于双向链表一样进行遍历判定是否为回文结构即可
//
//链表指针指向倒置思路（以a->b->c->d->e为例）：
//1、申请指针 x,y,z
//2、从a节点开始遍历，将其a,b,c分别赋值给x,y,z（x=a, y=b, z=c）
//3、将b指向a，此时即可得到两个链表结构(b->a, c->d->e)
//4、重复操作，将c指向b，得到c->b->a， d->e两个链表，直到所有指针都进行了指向倒置

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            Node front = null;
            Node head = null;
            int n = scanner.nextInt();
            for(int i = 0 ; i < n ; i++){
                char c = scanner.next().charAt(0);
                Node node = new Node(c);
                if(front == null){
                    head = node;
                }else {
                    front.next = node;
                }
                front = node;
            }

            if(func(head)){
                System.out.println("true");
            }else {
                System.out.println("false");
            }
        }
    }

    static class Node {
        char value;
        Node next;

        Node(char data) {
            this.value = data;
        }
    }

    // need O(1) extra space
    public static boolean func(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;//慢指针
        Node n2 = head;//快指针
        while (n2.next != null && n2.next.next != null) { // find mid node
            n1 = n1.next; // n1 -> mid//奇中点 偶前中点
            n2 = n2.next.next; // n2 -> end//奇数为终点，偶数倒数第二个数
        }
        //！~逆序的时候三个node，一个用来保存下一个节点遍历用，一个前node，一个后node，后node的next指向前node就可以了。不断移动前后node
        n2 = n1.next; // n2 -> right part first node
        n1.next = null; // mid.next -> null
        Node n3 = null;
        while (n2 != null) { // right part convert
            //~~逆序的步骤：第一，先将原先的next保存，第二步将原来的next变成last，last移动下一个，原先的node移动下一位。
            n3 = n2.next; // n3 -> save next node
            n2.next = n1; // next of right node convert
            n1 = n2; // n1 move //原先的n1是n2的上一个。n2 = n1.next
            n2 = n3; // n2 move //移动n2到下一个
        }
        n3 = n1; // n3 -> save last node //保存好最后的node，还原要从他开始。
        n2 = head;// n2 -> left first node //n2重新回到了初试位置
        boolean res = true;
        while (n1 != null && n2 != null) { // check palindrome
            if (n1.value != n2.value) {
                res = false;
                break;//注意这里的break
            }
            n1 = n1.next; // right to mid
            n2 = n2.next; //  left to mid
        }
        //把打乱的顺序还原回来
        n1 = n3.next;
        n3.next = null;//将最后的一个点指向null
        while (n1 != null) { // recover list
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
