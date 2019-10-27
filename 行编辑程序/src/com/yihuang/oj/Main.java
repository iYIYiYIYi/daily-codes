package com.yihuang.oj;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        do {
            Stack<Character> line = new Stack<>();
            String in = input.nextLine();
            char[] inchars = in.toCharArray();
            for (int i = 0; i < inchars.length; i++) {
                line.push(inchars[i]);
                if (inchars[i] == '@') {
                    line.clear();
                }
                if (inchars[i] == '#') {
                    line.pop();
                    line.pop();
                }
            }
            StringBuffer out = new StringBuffer();
            for (int i = 0; i < line.size(); i++) {
                out.append(line.get(i));
            }
            System.out.println(out);
        } while (input.hasNext());
    }
}
