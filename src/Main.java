//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class MyThread extends Thread {
    public  void run() {
        System.out.println("HI I am the thread!");
    }
}
class thread implements Runnable {
    public void run() {
        System.out.println("hi I am the thread from runnable !");
    }
}

public class Main {
    public static void main(String[] args) {
        //Thread using anonymous method
        Thread thread = new MyThread(){
            public void run() {
                System.out.println("This is the first thread!");
            }
        };
        thread.start();
        Thread thread2 = new MyThread(){
            @Override
            public void run() {
                System.out.println("This is the second thread!");
            }
        };
        thread2.start();
        Thread thread3 = new MyThread(){
            @Override
            public void run() {
                System.out.println("This is the third thread!");
            }
        };
        thread3.start();
        //Synchronization is the control the access of multiple threads to share resources
        //User to prevent  RACE CONDITION



    }




}