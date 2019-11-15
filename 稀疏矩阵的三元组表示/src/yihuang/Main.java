package yihuang;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input  = new Scanner(System.in);
        String ms = input.next();
        String ns = input.next();
        String ts = input.next();
        String parrtern = "[^0-9]";
        Pattern p = Pattern.compile(parrtern);
        Matcher ma  = p.matcher(ms);
        Matcher na = p.matcher(ns);
        Matcher ta = p.matcher(ts);
        String msn = ma.replaceAll("").trim();
        String nsn = na.replaceAll("").trim();
        String tsn = ta.replaceAll("").trim();
        int m = Integer.parseInt(msn);
        int n = Integer.parseInt(nsn);
        int t = Integer.parseInt(tsn);
        int[][]  arr = new int[m][n];
        for (int i = 0; i < t; i++) {
            int h = input.nextInt();
            int l = input.nextInt();
            int val = input.nextInt();
            arr[h][l] = val;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }System.out.println();
        }
    }
}
