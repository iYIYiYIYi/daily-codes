package yihuang;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private int[][] reset(int r,int c,ArrayList<Integer[]> list){
        int[][] map = new int[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int k = 0;
                while (k < list.size()) {
                    if (list.get(k)[0] == i&&list.get(k)[1] == j) {
                        map[j][i] = list.get(k)[2];
                        break;
                    }else
                        map[j][i] = 0;
                    k++;
                }
            }
        }
        return map;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        ArrayList<Integer[]> list = new ArrayList<>();
        int r = input.nextInt();
        int c = input.nextInt();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int in = input.nextInt();
                Integer[] inarr = {i,j,in};
                if(in!=0)
                    list.add(inarr);
            }
        }

        Main main = new Main();
        int[][] map = main.reset(r,c,list);
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }
}
