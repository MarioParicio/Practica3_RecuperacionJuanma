package org.example;

public class Model {
    static int i;
    static int i1;

    public Model() {
        i = A.getI();
    }

    static{
        i = A.getI();
    }


    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Model.i = i;
    }

    public static int getI1() {
        return i1;
    }

    public static void setI1(int i1) {
        Model.i1 = i1;
    }
}
