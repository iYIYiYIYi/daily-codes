package com.yihuang.oj;

import java.util.Scanner;

public class Main {

    static int[] xnums = new int[10000];
    static int counter = 0;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int xnum = input.nextInt();
        int znum = input.nextInt();
        while (xnum!=-1&&znum!=-1) {
            if (znum == 0) ;
            if (znum != 0) xnums[znum-1] = xnum*znum+xnums[znum-1];
            xnum = input.nextInt();
            znum = input.nextInt();
        }

        for (int i = xnums.length-1; i >= 0 ; i--) {
            counter = counter + xnums[i];
            if (xnums[i] != 0) {
                System.out.printf("%d %d ",xnums[i],i);
            }
        }
        if(counter==0) System.out.println(0);
    }
}
