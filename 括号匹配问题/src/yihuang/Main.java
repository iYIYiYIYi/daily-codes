package yihuang;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        do {
            String in = input.nextLine();
            int flag = 0;
            Stack<Character> left = new Stack<>();
            char[] inchar = in.toCharArray();
            for (int i = 0; i < inchar.length; i++) {
                if (inchar[i] == 'P') {
                    left.push(inchar[i]);
                }
                if (inchar[i] == 'Q') {
                    if (left.isEmpty()) {
                        flag = 1;
                        break;
                    }
                    left.pop();
                }
            }
            if (left.isEmpty() && flag == 0) {
                System.out.println("Y");
            }else
                System.out.println("N");
        }while(input.hasNext());
    }
}
