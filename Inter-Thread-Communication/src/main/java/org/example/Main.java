package org.example;

class Q{
    int num;

    public void put(int num){
        System.out.println("PUT :"+ num);
        this.num = num;
    }

    public void get(){
        System.out.println("GET :"+ num);
    }
}

class Producer implements Runnable{

    Q q;

    public Producer(Q q){
        this.q = q;
        Thread t = new Thread(this,"Producer");
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            q.put(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class Consumer implements Runnable{

    Q q;

    public Consumer (Q q){
        this.q = q;
        Thread t = new Thread(this,"Consumer");
        t.start();
    }

    @Override
    public void run() {

        int i = 0;

        while(true){
            q.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class Main {
    public static void main(String[] args) {

    }
}