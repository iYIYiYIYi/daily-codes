package com.yihuang.oj;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);

        do {
            StringBuffer out = new StringBuffer();
            String in = input.nextLine();
            char[] inchar = in.toCharArray();
            for (int i = 0; i < inchar.length; i++) {
                int counter = 0,index = 0;
                if (inchar[i] == ')') {

                    int c = i-1,r=0;
                    while (c>=0){
                        if (inchar[c] == ')') {
                            r++;
                        }else if (inchar[c] == '('&&r==0) {
                            index = c;
                            break;
                        }else if (inchar[c] == '('){
                            r--;
                        }
                        c--;
                    }
                    for (int j = index; j <= i; j++) {
                        if (inchar[j] == ')') {
                            counter++;
                        }
                    }
                            out.append(counter+" ");

                }
            }
            System.out.println(out);
        } while (input.hasNext());
    }
}
