package yihuang;

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

    private static int width = 0;
    private static int wide(Node newnode) {
        if (newnode == null||newnode.value == '#')
            return 0;

        int tmpWidth = 1;
        LinkedList<Node> levelnodes = new LinkedList<>();
        levelnodes.add(newnode);
        while (!levelnodes.isEmpty()) {
            LinkedList<Node> tmpLevenodes = new LinkedList<>();
            int tmp = 0;
            for (Node node : levelnodes) {
                if (node.left != null && node.left.value != '#') {
                    tmpLevenodes.add(node.left);
                    tmp++;
                }
                if (node.right != null && node.right.value != '#') {
                    tmpLevenodes.add(node.right);
                    tmp++;
                }
            }
            tmpWidth = tmpWidth>tmp?tmpWidth:tmp;
            levelnodes = tmpLevenodes;
        }

        return tmpWidth;
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
//        int n = in.nextInt();
       while (in.hasNext()){
            String instring = in.next();
            char[] inchars = instring.toCharArray();
            input(inchars);
            Node newnode = root;

//            depth = deep(newnode)-1;
            width = wide(newnode);
            System.out.println(width);

            destroy();
        }
    }
}