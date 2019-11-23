package yihuang;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int tmp = input.nextInt();
            nums.add(tmp);
        }
        Integer[] searchnums = new Integer[n];
        for (int j = 0; j < n; j++) {
            int num = input.nextInt();
            searchnums[j] = num;
        }
        StringBuffer out = new StringBuffer();
        for (Integer j:searchnums) {
            if (nums.contains(j))
                out.append(1 + " ");
            else if (!nums.contains(j))
                out.append(0 + " ");
        }
        System.out.println(out);
    }
}
