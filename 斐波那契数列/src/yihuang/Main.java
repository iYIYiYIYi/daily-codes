package yihuang;

import java.util.Scanner;

public class Main {

    static int[] fbnq = new int[10000];

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        fbnq[0] = 0;
        fbnq[1] = 1;
        for (int i = 2; i < fbnq.length; i++) {
            fbnq[i] = fbnq[i-1] + fbnq[i-2];
        }
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            System.out.println(fbnq[n]);
        }
    }
}
