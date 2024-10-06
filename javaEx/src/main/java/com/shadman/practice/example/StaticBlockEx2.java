package com.shadman.practice.example;

//Tell the output of the following code
public class StaticBlockEx2 {
    public static void main(String[] args) {
        System.out.println(StaticStringClass.histring);
        new StaticStringClass();
        System.out.println(StaticStringClass.histring);
        new StaticStringClass();
    }

    public static class StaticStringClass {
        static String histring;
        static {
            System.out.println("hi i am static block");//1 --a
            histring = "hi i am static string set from static block"; //2 --b
        }
        StaticStringClass(){
            System.out.println("i am called from constructor");//3
            histring = "hi i am static string set from constructor";//4
        }
    }
}
