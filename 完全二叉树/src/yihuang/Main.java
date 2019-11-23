package yihuang;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

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
                if (node.left != null ) {
                    tmpLevenodes.add(node.left);
                    tmp++;
                }
                if (node.right != null ) {
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
        if(newnode == null)
            return true;

        Vector<Node> nodes = new Vector<>();
        nodes.add(root);
        int i = 0;
        while (i < nodes.size() && nodes.get(i) !=null)
        {
            nodes.add(nodes.get(i).left);
            nodes.add(nodes.get(i).right);
            i++;
        }
        while (i < nodes.size() && !(nodes.get(i) != null)) i++;
        return i == nodes.size();
    }

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        while (in.hasNext()){
            String instring = in.next();
            char[] inchars = instring.toCharArray();
            root = input(inchars);
            Node newnode = root;

//            depth = deep(newnode)-1;
//            width = wide(newnode);
            if (isCompleted(newnode))
                System.out.println("Yes");
            else
                System.out.println("No");

            destroy();
        }
    }
}