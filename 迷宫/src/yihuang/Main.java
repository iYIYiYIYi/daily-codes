package yihuang;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static char[][] map = new char[10][10];
    private static char s = 'S';
    private static char e = 'E';
    private static char r = '*';
    private static char ur = '!';

    private static int xs,ys,xe = -1,ye = -1;

    private static Stack<Integer> routex = new Stack<>();
    private static Stack<Integer> routey = new Stack<>();

    private static boolean forward() {
        if (routey.isEmpty()) {
            routey.push(xt);
            routex.push(yt);
            map[xt][yt] = r;
            rightforward();
            return true;
        }
        return false;
    }

    private static boolean rightforward() {
        int xl = routex.peek();
        int yl = routey.peek();
        if (map[xt][yt + 1] == ' '||map[xt][yt + 1] == e) {
            routex.push(yt);
            routey.push(xt);
            yt++;
            map[xt][yt] = r;
            return true;
        }else if (map[xt + 1][yt] == ' '||map[xt + 1][yt] == e) {
            routex.push(yt);
            routey.push(xt);
            xt++;
            map[xt][yt] = r;
            return true;
        }else if (map[xt][yt - 1] == ' '||map[xt][yt - 1] == e) {
            routex.push(yt);
            routey.push(xt);
            yt--;
            map[xt][yt] = r;
            return true;
        }else if (map[xt - 1][yt] == ' '||map[xt - 1][yt] == e) {
            routex.push(yt);
            routey.push(xt);
            xt--;
            map[xt][yt] = r;
            return true;
        }
        return false;
    }

    static int xt ,yt ;
    private static void explore(){
        yt = ys;xt = xs;

        while (yt!=ye||xt!=xe) {
            if (!forward()) {
                if (!rightforward()) {
                    map[xt][yt] = ur;
                    xt = routey.pop();
                    yt = routex.pop();
                    if (routex.isEmpty()&&yt == ys && xt == xs) {
                        map[xt][yt] = ur;
                        return;
                    }
                }
            }
        }

    }

    private static void paintMap() {
        for (int i = 0; i < 10; i++) {
            System.out.println(map[i]);
        }
    }

    private static Scanner input = new Scanner(System.in);
    private static void getMap() {
        for (int i = 0; i <= 9; i++) {
            if (input.hasNextLine()){
                String line = input.nextLine();
                char[] linec = line.toCharArray();
                if (line.contains("S")) {
                    ys = line.indexOf("S");
                    xs = i;
                }
                if (line.contains("E")) {
                    ye = line.indexOf("E");
                    xe = i;
                }

                map[i] = linec;
            }

        }
    }

    public static void main(String[] args) {
	// write your code here
        getMap();
        explore();
        paintMap();
    }
}
