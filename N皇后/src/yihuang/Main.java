package yihuang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        NQueen1 nq = new NQueen1(n);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < nq.resultList.get(i).size(); j++) {
                System.out.print(nq.resultList.get(i).get(j)+1+" ");
            }System.out.println();
        }
        System.out.println(nq.resultList.size());
    }
}

class NQueen1 {

    private int EAGELENGTH ;
    public LinkedList<ArrayList<Integer>> resultList = new LinkedList<>();
    public int x[] ;
    public NQueen1() {}
    public NQueen1(int n) {
        EAGELENGTH = n;
        ArrayList<Integer> list = new ArrayList<>();
        calculateQueens(list);
    }

    public void calculateQueens(ArrayList<Integer> locationList) {

        if (locationList.size() == EAGELENGTH) {//已经找完n行
            //为什么这样要复制才可以，直接add到resultlist，里面的内容为空？？
            ArrayList<Integer> locationListClone = new ArrayList<>();
            locationListClone.addAll(locationList);
            resultList.add(locationListClone);
            return;
        }
        //递归求解
        for (Integer i = 0; i < EAGELENGTH; i++) {
            if (!locationList.contains(i)) {//同一列没有重复
                boolean flag = true;
                for (int j = 0; j < locationList.size() && flag; j++) {
                    //对角线重复了，flag=false
                    if (Math.abs(i - locationList.get(j)) == Math.abs(locationList.size() - j))
                        flag = false;
                }
                if (flag) {
                    //满足摆放条件
                    locationList.add(i);
                    calculateQueens(locationList);
                    locationList.remove(locationList.size() - 1);//回溯
                }
            }
        }
        return;

    }

}