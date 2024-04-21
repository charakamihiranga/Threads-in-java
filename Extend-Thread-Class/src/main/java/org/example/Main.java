package org.example;

class One extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread One");
        }
    }
}

class Two extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread Two");
        }
    }
}

public class Main {
    public static void main(String[] args) {
       One one = new One();
       Two two = new Two();
       one.start();
       two.start();
    }
}