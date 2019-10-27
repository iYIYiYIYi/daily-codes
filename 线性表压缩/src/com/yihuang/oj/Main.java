package com.yihuang.oj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner input = new Scanner(System.in);
        int M = input.nextInt();

        for (int i=0;i<M;i++) {
            int counter = 0;
            int N = input.nextInt();
            int[][] list = new int[10000][2];
            for (int j = 0; j < N; j++) {
                int in = input.nextInt();
                list[j][0] = in;
                if(in != 0){
                    list[j][1] = j;
                }
            }
            int zip = 0;
            for(int m = 0; m<list.length;m++){
                if (list[m][0] != 0) {
                    zip = list[m][0]*(list[m][1]-counter)+zip;
                    counter++;
                }
            }
            System.out.print(zip+" "+counter+" ");
            for (int out = 0; out < list.length; out++) {
                if(list[out][0]!=0)System.out.printf("%d ",list[out][0]);
            }
            System.out.println();
        }


    }
}
