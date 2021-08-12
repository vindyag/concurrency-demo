package demo.synchronization;

/*
Race Condition Example
 */
public class CalculatorMain {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Thread backgroundThread1 = new Thread(() -> {
            try {
                calculator.setAndGetSum(100, 300, 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        backgroundThread1.start();

        Thread backgroundThread2 = new Thread(() -> {
            try {
                calculator.setAndGetSum(200, 400, 600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        backgroundThread2.start();
    }


}
