package jichulianxi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTime {
    public static void main(String[] args) {
        List array = new ArrayList();
        List link = new LinkedList();
        for (int i=1;i<=100000;i++){
            array.add(i);
            link.add(i);
        }

        long begin1 = System.currentTimeMillis();
        for (int i=1;i<=100000;i++){
            array.remove(0);
        }
        long end1 = System.currentTimeMillis();

        long begin2 = System.currentTimeMillis();
        for (int i=1;i<=100000;i++){
            link.remove(0);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end1-begin1);
        System.out.println(end2-begin2);
    }
}
