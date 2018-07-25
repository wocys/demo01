package jichulianxi;

public class DuoTai {
    public static void main(String[] args) {
//        jichulianxi.Person p = new jichulianxi.Student();
//        jichulianxi.Person p2 = new jichulianxi.Student();
        String s1 =new String( "abc");
        System.out.println(s1=="abc");
    }
}
class Person{
    void run(){
        System.out.println("人类跑");
    }
}
class Student extends Person{
    void run(){
        System.out.println("学生跑");
    }
}
