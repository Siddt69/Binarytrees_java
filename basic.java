import java.util.LinkedList;
import java.util.Queue;

public class basic {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val= val;
        }
    }
    public static void display(Node root){
        if(root==null) return;
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }
    public static void leveorder(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(q.size()>0){
            Node front = q.remove();
            System.out.println(front.val+" ");
            if(front.left!=null) q.add(front.left);
            if(front.right!=null) q.add(front.right);
        }
//        System.out.println();
    }
    static int ans;
    public static int sum(Node root){
        if(root==null) return 0;

        ans += root.val;
        sum(root.left);
        sum(root.right);
        return ans;
    }
    static int prod;
    public static int product(Node root){
        if(root==null) return 1;
        prod *= root.val;
        product(root.left);
        product(root.right);
        return prod;
    }
    public static int levels(Node root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    static int max;
    public static int max(Node root){
        if(root==null) return Integer.MIN_VALUE;

        max = Math.max(root.val,Math.max(max(root.left),max(root.right)));
        return max;
    }
    static int count;
    public  static int totalnodes(Node root){
        if(root==null) return 0;
        count++;
        totalnodes(root.left);
        totalnodes(root.right);
        return count;
    }
    public static  class treeNode {

        public static void main(String[] args) {
            Node a = new Node(1);
            Node b = new Node(41);
            Node c = new Node(3);
            Node d = new Node(2);
            Node e = new Node(6);
            Node f = new Node(5);
            Node g = new Node(10);


            a.left = b;a.right= c;
            b.left = d;b.right = e;
            c.right = f; c.left = g;

            display(a);
            ans=0;
            int add =  sum(a);
            System.out.println();
            System.out.println(add);
            prod=1;
            System.out.println(product(a));
            max = -1;
            System.out.println(max(a));
            count = 0;
            System.out.println(totalnodes(a));
            System.out.println(levels(a));
            System.out.print("level order :");
            leveorder(a);
        }
    }
}
