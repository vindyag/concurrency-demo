package demo.test;

import demo.test.Example;

public class Main {
    public static void main(String[] args) {
        Example example = new Example();
            Thread backgroundThread2 = new Thread(() -> {
                try {
                    example.setAndGetSum(100,300,500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        backgroundThread2.start();

        Thread backgroundThread = new Thread(() -> {
                try {
                    example.setAndGetSum(200,400,600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            backgroundThread.start();
    }


}
