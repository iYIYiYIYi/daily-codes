package com.yihuang.oj;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static StringBuffer out = new StringBuffer();
    static Stack<Integer> integerStack = new Stack<>();
    static Stack<Integer> inputStack = new Stack<>();

    private static int x=1;
    private static void push() {
        integerStack.push(x);
        x++;
        out.append('P');
    }

    private static void pop() {
        integerStack.pop();
        inputStack.pop();
        out.append('Q');
    }

    private static void judge(int length) {

            if (integerStack.empty()||integerStack.peek() != inputStack.peek()) {
                push();
            }
            if (integerStack.peek()==inputStack.peek()) {
                pop();
            }
            if (inputStack.empty()) {
                return;
            }
            if (!integerStack.empty()&&!inputStack.empty()&&integerStack.peek()>inputStack.peek()) {
                out.append(" error");
                return;
            }
            judge(length);
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        do {
            int length = input.nextInt();
            Stack<Integer> in = new Stack<>();
            for (int i = 0; i < length; i++) {
                in.push(input.nextInt());
            }
            for (int i = 0; i < length; i++) {
                inputStack.push(in.pop());
            }
            judge(length);
            System.out.println(out);
            out.delete(0,out.length());
            integerStack.clear();
            inputStack.clear();
            x=1;
        }while(input.hasNext());

    }
}
