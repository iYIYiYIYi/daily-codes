package com.yihuang.oj;

import java.util.Scanner;

public class Main {

    static int counter = 0;
    private static void move(int n,char x,char y) {
        counter++;
        System.out.printf("%2d. Move disk %d from %c to %c\n",counter,n,x,y);
    }

    private static void hanoi(int n,char x,char y,char z) {
        if (n == 1) {
            move(1, x, z);
        } else {
            hanoi(n-1,x,z,y);
            move(n,x,z);
            hanoi(n-1,y,x,z);
        }
    }

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        do {
            int n = input.nextInt();
            hanoi(n,'X','Y','Z');
            counter = 0;
            System.out.println();
        }while (input.hasNext());
    }
}
