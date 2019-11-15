package yihuang;

import java.util.Scanner;

public class Main {

    private int[] nextval(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < t.length - 1) {
            if (j == -1 || t[i] == t[j]) {
                i++;
                j++;
                if (t[i] != t[j]) {
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String in = input.next();
            Main main = new Main();
            int[] out = main.nextval(in.toCharArray());
            for (int i:out) {
                System.out.print(i+" ");
            }System.out.println();
        }


    }
}
