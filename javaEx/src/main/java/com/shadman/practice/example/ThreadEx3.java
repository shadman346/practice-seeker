package com.shadman.practice.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class ThreadEx3 {

    public static void main(String[] args) {
        DataWarehouse dataWarehouse = new DataWarehouse(5);
        Thread producer = new Thread(new Producer(dataWarehouse));
        Thread producer2 = new Thread(new Producer(dataWarehouse));
        Thread consumer = new Thread(new Consumer(dataWarehouse));
        producer.start();
        producer2.start();
        consumer.start();
    }

    static class DataWarehouse{
        Deque<String> queue = new LinkedList<>();
        int size;
        DataWarehouse(int size){
            this.size = size;
        }
        public synchronized void produceItem(String item) throws InterruptedException {
            System.out.println(Thread.currentThread() + ":: trying adding to datawarehouse: " + item + " and datawarehouse size: " + queue.size());
            while(queue.size() == size){
                wait();
            }
            queue.addLast(item);
            System.out.println(Thread.currentThread() + ":: item added to datawarehouse: " + item + " and datawarehouse size: " + queue.size());
            notifyAll();
        }
        public synchronized String consumeItem() throws InterruptedException {
            System.out.println(Thread.currentThread() + ":: trying consuming from datawarehouse and datawarehouse size: " + queue.size());
            while(queue.isEmpty()){
                wait();
            }
            String item = queue.removeFirst();
            System.out.println(Thread.currentThread() + ":: item consumed from datawarehouse: " + item + " and datawarehouse size: " + queue.size());
            notifyAll();
            return item;
        }
    }

    static class Consumer implements Runnable{
        DataWarehouse dataWarehouse;
        Consumer(DataWarehouse dataWarehouse){
            this.dataWarehouse = dataWarehouse;
        }
        @Override
        public void run() {
            while(true){
                Random random = new Random();
                int randomSleep = random.nextInt(4000,10000);
                try {
                    Thread.sleep(randomSleep);
                    String item = dataWarehouse.consumeItem();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Producer implements Runnable{
        DataWarehouse dataWarehouse;
        Producer(DataWarehouse dataWarehouse){
            this.dataWarehouse = dataWarehouse;
        }

        @Override
        public void run() {
            while(true){
                Random random = new Random();
                int randomSleep = random.nextInt(1000,5000);
                try {
                    Thread.sleep(randomSleep);
                    String item = SentenceGenerator.generateRandomSentence();
                    dataWarehouse.produceItem(item);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
