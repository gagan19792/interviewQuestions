package org.interview.questions.thread;

public class ThreadDemo {



    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        Thread myRunnableThread = new Thread(new MyRunnableThread());
        myThread.start();
        myRunnableThread.start();
        Thread t = new Thread(() -> System.out.println("Hello from a lambda Runnable!"));
        t.start();

    }
}

class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread Name : "+this.getName());
    }
}

class MyRunnableThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a Runnable!");
    }
}
