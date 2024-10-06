package com.shadman.practice.example;

public class ThreadEx1 {

    //How can I make sure that result of thread A is always print before thread B
    // and result of thread B always before thread C
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(()-> System.out.println("hi from thread"));
        Thread threadB = new Thread(new PrintMyName("Andrew"));
        Thread threadC = new PrintMyPetNameThread("Tommy");

        threadA.start();
        threadA.join();
        threadB.start();
        threadB.join();
        threadC.start();
    }

    private static class PrintMyName implements Runnable{
        private final String name;
        PrintMyName(String name){
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.name);
        }
    }

    private static class PrintMyPetNameThread extends Thread{
        private String name;
        PrintMyPetNameThread(String name){
            this.name = name;
        }
        public void run() {
            System.out.println(this.name);
        }

    }
}
