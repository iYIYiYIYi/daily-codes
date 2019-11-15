package yihuang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input =  new Scanner(System.in);
        ArrayList<Integer[]> list = new ArrayList<>();
        ArrayList<Integer[]> list2 = new ArrayList<>();
        int r1 = input.nextInt();
        int c1 = input.nextInt();
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                int num = input.nextInt();
                if (num != 0) {
                    list.add(new Integer[]{i,j,num});
                }
            }
        }
        int r2 = input.nextInt();
        int c2 = input.nextInt();
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                int num = input.nextInt();
                if (num != 0) {
                    list2.add(new Integer[]{i,j,num});
                }
            }
        }

        int rr = 0,cc = 0,count = 0;
        int[][] res = new int[r1][c2];
        while (!list.isEmpty()&&count<list.size()) {
            int count1 = 0;
            while (count1 < list2.size()) {
                int result = 0;
                if (list.get(count)[1] == list2.get(count1)[0]) {
                    result = list.get(count)[2]*list2.get(count1)[2];
                    res[list.get(count)[0]][list2.get(count1)[1]] += result;
                }
                count1++;
            }
            count++;
        }

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(res[i][j]+" ");
            }System.out.println();
        }

    }
}
