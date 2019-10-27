package com.yihuang.oj;

import java.util.Scanner;
        import java.util.Vector;

public class Main {

    private static Vector[] queue;
    private static int[][] windows;
    private static int time;
    private static int waitingTime;

    private static void initVector() {
        for (int i = 0; i < 10000; i++) {
            queue[i] = new Vector();
        }
    }

    private static void initWindow() {
        for (int i = 0; i < windows.length; i++) {
            if (windows[i][0] == 1) {
                if (time >= windows[i][1]) {
                    windows[i][0] = 0;
                }
            }
        }
    }

    private static void chooseWindow(int occurtime,int contime) {
        Vector<Integer> wins = new Vector<>();
        initWindow();
        for (int i = 0; i < windows.length; i++) {
            if (windows[i][0] == 0) {
                wins.add(i);
            }
        }
        if (wins.size() == 0) {
            int min = 99999;
            int index = 0;
            int counter = 0;
            for (int j = 0; j < windows.length; j++) {
                if (windows[j][1] < min) {
                    min = windows[j][1];
                    index = j;
                    counter++;
                }
            }
            if (counter > 1) {
                for (int i = 0; i < windows.length; i++) {
                    if (windows[i][1] == min) {
                        index = i;
                        break;
                    }
                }
            }
            waitingTime += windows[index][1] - occurtime;
            windows[index][0] = 1;              //whether this window is working
            windows[index][1] += contime;       //end time
            windows[index][2] += contime;       //work time
            return;
        }
        if (wins.size() > 0) {
            int min = 99999;
            int index = 0;
            int counter = 0;
            for (int j = 0; j < windows.length; j++) {
                if (windows[j][2] < min) {
                    min = windows[j][2];
                    index = j;
                    counter++;
                }
            }
            if (counter > 1) {
                for (int i = 0; i < windows.length; i++) {
                    if (windows[i][2] == min) {
                        index = i;
                        break;
                    }
                }
            }
            windows[index][0] = 1;              //whether this window is working
            windows[index][1] = time + contime;       //end time
            windows[index][2] += contime;       //work time
            return;
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        do {
            int m = input.nextInt();
            int total = input.nextInt();
            queue = new Vector[10000];
            windows = new int[m][3];
            time = 0;
            waitingTime = 0;
            initVector();

            for (int i = 0; i < total; i++) {
                int timein = input.nextInt();
                int contiTime = input.nextInt();
                queue[timein].add(contiTime);
            }
            while (time < 10000) {
                while (!queue[time].isEmpty()) {
                    chooseWindow(time, (Integer) queue[time].firstElement());
                    queue[time].remove(0);
                }
                time++;
            }

            double res = (double)waitingTime/total;
            System.out.println(String.format("%.2f",res));
        } while (input.hasNext());
    }
}
