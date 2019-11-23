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
    private static Node input(char[] elems) {
        if (count>=elems.length)
            return null;

        if (elems[count] == '#') {
            count++;
            return null;
        }
        Node newnode = new Node(elems[count],null,null);
        count++;
        newnode.left = input(elems);
        newnode.right = input(elems);
        return newnode;
    }

    static StringBuffer outByRoot = new StringBuffer();
    private static void outputByRoot(Node newnode) {
        if (newnode == null)
            return;
        outByRoot.append(newnode.value+" ");
        outputByRoot(newnode.left);
        outputByRoot(newnode.right);
    }

    static StringBuffer outByMiddle = new StringBuffer();
    private static void outputByMiddle(Node newnode) {
        if (newnode == null)
            return;

        outputByMiddle(newnode.left);
        outByMiddle.append(newnode.value+" ");
        outputByMiddle(newnode.right);
    }

    static StringBuffer outByLast = new StringBuffer();
    private static void outputByLast(Node newnode) {
        if (newnode == null)
            return;

        outputByLast(newnode.left);
        outputByLast(newnode.right);
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

    static int depth = 0;
    private static int deep(Node newnode) {
        if (newnode == null)
            return 0;

        int nleft = deep(newnode.left);
        int nright = deep(newnode.right);
        return nleft>nright?nleft+1:nright+1;
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

    private static boolean isCompleted(Node newnode) {
        if(newnode == null||newnode.value == '#')
            return true;

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
                if ( (node.right.value != '#') && ( node.left.value == '#')) {
                    return false;
                }
                if ((node.right.value == '#')
                        && (node.left.value != '#')
                        && (node.left.left.value != '#'
                        || node.left.right.value != '#')) {
                    return false;
                }
            }
            tmpWidth = tmpWidth>tmp?tmpWidth:tmp;
            levelnodes = tmpLevenodes;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        while (in.hasNext()){
            String instring = in.nextLine();
            instring = instring.replaceAll(" ","#");

            char[] inchars = instring.toCharArray();
            root = input(inchars);

            Node newnode = root;

            outputByRoot(newnode);
            System.out.println(outByRoot);

            outputByMiddle(newnode);
            System.out.println(outByMiddle);
            System.out.println(outByMiddle);

//            depth = deep(newnode)-1;
//            width = wide(newnode);
//            if (isCompleted(newnode))
//                System.out.println("Yes");
//            else
//                System.out.println("No");

            destroy();
//        }
    }
}