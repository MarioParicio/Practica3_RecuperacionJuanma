package org.example;

public class Main {
    public static void main(String[] args) {

        A a = new A();
        a.setI(5);
        Model m = new Model();
        System.out.println(m.getI());
        a.setI(6);
        Model m1 = new Model();
        System.out.println(m1.getI());
    }
}