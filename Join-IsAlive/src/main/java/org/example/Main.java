package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread One");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread Two");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

        //to check  thread is alive if it has been started and has not yet died

        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());

        //Thread class provides the join() method which allows one thread to wait until another thread completes its execution.
        // If t is a Thread object whose thread is currently executing,
        // then t. join() will make sure that t is terminated before the next instruction is executed by the program.

        t1.join();
        t2.join();

        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());


        System.out.println("BYE");
    }
}