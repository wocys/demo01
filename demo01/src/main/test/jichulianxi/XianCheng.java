package jichulianxi;

import java.util.ArrayList;
import java.util.List;

class Xian implements Runnable{
    List list;
    Xian(List list){
        this.list=list;
    }

    @Override
    public synchronized void run() {
        for (Object o:list){
            System.out.println(Thread.currentThread().getName()+":"+o);
        }
    }
}

public class XianCheng {
    public static void main(String[] args) {
        new Integer(18);
        List list=new ArrayList();
        for (int i=1;i<=100;i++){
            list.add(i);
        }
        Xian xian = new Xian(list);
        Thread t1 = new Thread(xian,"线程一");
        Thread t2 = new Thread(xian,"线程二");
        t1.start();
        t2.start();
    }
}
