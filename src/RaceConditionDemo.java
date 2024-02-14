public class RaceConditionDemo {
    private static  Integer counter = 0 ;
    private static Object lock = new Object();
    public static void main(String[] args) throws  InterruptedException {
        // Create threads
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000000000; i++) {
                    // synchronization block
                  synchronized (this) {
                      counter++;
                  }
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        thread1.start();
        thread2.start();
        //wait for other threads to finish
        thread1.join();
        thread2.join();
        System.out.println("Expected value:20000 ");
        System.out.println("Actual value: "+ counter);

    }
}
