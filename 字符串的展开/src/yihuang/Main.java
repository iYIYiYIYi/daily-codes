package yihuang;

import java.util.Scanner;

public class Main {

    private String replace(int p1,int p2,int p3,char s,char e){
        StringBuffer out = new StringBuffer();
        if (e - s == 1)
            return out.toString();
        if (s == e||s > e)
            return out.append("-").toString();
        char app = (char) (s+1);
        while (app < e) {
            if (p1==2&&app<='z'&&app>='a') {
                for (int i = 0; i < p2; i++) {
                    out.append((char)(app+'A'-'a'));
                }
                app++;
            } else if (p1 == 3) {
                for (int i = 0; i < p2; i++) {
                    out.append('*');
                }
                app++;
            } else {
                for (int i = 0; i < p2; i++) {
                    out.append(app);
                }
                app++;
            }
        }
        if (p3>1)
            out.reverse();

        return out.toString();
    }

    private void split(int p1, int p2, int p3,String in) {
        char[] inChar = in.toCharArray();
        StringBuffer stringBuffer = new StringBuffer(in);
        int l = 0;
        for (int i = 0; i < in.length(); i++) {
            if (i>0&&inChar[i] == '-'&&i<inChar.length-1) {
                char s = inChar[i-1];
                char e = inChar[i+1];
                if ((s >= 'a' && s <= 'z') && (e >= 'a' && e <= 'z') || (s >= '0' && s <= '9') && (e >= '0' && e <= '9') || (s >= 'A' && s <= 'Z') && (e >= 'A' && e <= 'Z')) {
                    String restring = this.replace(p1,p2,p3,s,e);
                    stringBuffer.deleteCharAt(i+l);
                    stringBuffer.insert(i+l,restring);
                    l += restring.length()-1;
                }
            }
        }
        System.out.println(stringBuffer);
    }

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            Main main = new Main();
            int p1 = input.nextInt();
            int p2 = input.nextInt();
            int p3 = input.nextInt();
            String in = input.next();
            main.split(p1,p2,p3,in);
        }
    }
}
