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
            if (removec != '#')
                outByStage.append(removec);
        }
    }

    private static void destroy() {
        root = null;
        lastnodes = new Stack<>();
        count = 0;
        outByStage = new StringBuffer();
        outByLast = new StringBuffer();
        outByMiddle = new StringBuffer();
    }

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String instring = in.nextLine();
            char[] inchars = instring.toCharArray();
            input(inchars);
            Node newnode = root;

            outputByMiddle(newnode);
            System.out.print(outByMiddle);

            outputByLast(newnode);
            System.out.print(" "+outByLast);

            outputByStage(newnode);
            System.out.print(" "+outByStage);
            System.out.println();

            destroy();
        }
    }
}
