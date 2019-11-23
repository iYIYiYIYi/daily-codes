package yihuang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static class Node{
        Node left;
        Node right;
        char value;

        public Node(char value,Node left,Node right){
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }



    private static Node root ;

    private static Node inputByPreAndIn(char[] pre, char[] in) {
        if(pre.length == 0)
            return null;

        Node newnode = null;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                newnode = new Node(pre[0],null,null);
                newnode.left = inputByPreAndIn(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                newnode.right = inputByPreAndIn(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return newnode;
    }

    private static int count = 0;
    private static Stack<Node> lastnodes = new Stack<>();
    private static void input(char[] elems) {
        if (count>=elems.length)
            return;
        Node newnode = new Node(elems[count],null,null);

        if (lastnodes.size() == 0) {
            root = newnode;
            lastnodes.push(root);
            count++;
            input(elems);
            return;
        }

        if (lastnodes.lastElement().left == null) {
            lastnodes.lastElement().left = newnode;
            count++;
            if((!lastnodes.contains(newnode))&&newnode.value!='#')
                lastnodes.push(newnode);
        } else if (lastnodes.lastElement().right == null) {
            lastnodes.lastElement().right = newnode;
            count++;
            if((!lastnodes.contains(newnode))&&newnode.value!='#')
                lastnodes.push(newnode);
        }else
            return;

        input(elems);
        if (lastnodes.size() == 0)
            return;
        lastnodes.pop();
        input(elems);
    }

    static StringBuffer outByMiddle = new StringBuffer();
    private static void outputByMiddle(Node newnode) {
        if (newnode == null)
            return;

        outputByMiddle(newnode.left);
        if(newnode.value!='#')
            outByMiddle.append(newnode.value);
        outputByMiddle(newnode.right);
    }

    static StringBuffer outByLast = new StringBuffer();
    private static void outputByLast(Node newnode) {
        if (newnode == null)
            return;

        outputByLast(newnode.left);
        outputByLast(newnode.right);
        if (newnode.value!='#')
            outByLast.append(newnode.value);
    }

    static StringBuffer outByStage = new StringBuffer();
    private static void outputByStage(Node newnode) {
        if (newnode == null)
            return;

        LinkedList<Node> nodes = new LinkedList<>();
        nodes.offer(newnode);
        while (!nodes.isEmpty()) {
            if (nodes.getFirst().left != null)
                nodes.offer(nodes.getFirst().left);
            if(nodes.getFirst().right != null)
                nodes.offer(nodes.getFirst().right);
            char removec = nodes.removeFirst().value;
            if (removec != '#'){
                outByStage.append(removec);
            }
        }
    }

    private static void destroy() {
        root = null;
        depth = 0;
        lastnodes = new Stack<>();
        count = 0;
        outByStage = new StringBuffer();
        outByLast = new StringBuffer();
        outByMiddle = new StringBuffer();
    }

    static int depth = 0;
    private static int deep(Node newnode) {
        if (newnode == null)
            return 0;

        int nleft = deep(newnode.left);
        int nright = deep(newnode.right);
        return nleft>nright?nleft+1:nright+1;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String preS = in.next();
            String inS = in.next();
            char[] preC = preS.toCharArray();
            char[] inC = inS.toCharArray();
            root = inputByPreAndIn(preC,inC);
            Node newnode = root;

            outputByLast(newnode);
            System.out.println(outByLast);
            destroy();
        }
    }
}
