package com.yihuang.oj;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> integerStack = new Stack<>();
        Scanner input = new Scanner(System.in);

        int counter = 1;
        do {
            String s = input.nextLine();
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (chars[i] == 'P') {
                    integerStack.push(counter);
                    counter++;
                } else if (chars[i] == 'Q') {
                    try {
                        int out = integerStack.pop();
                        System.out.print(out+" ");
                    } catch (EmptyStackException error) {
                        System.out.print("error ");
                        break;
                    }
                }
            }
            counter = 1;
            integerStack.clear();
            System.out.println();
        }while(input.hasNext());
    }
}
