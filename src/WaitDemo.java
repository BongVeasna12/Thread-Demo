class Data {
    int  msg ;
    int count;
    boolean valueSet = false;
    public synchronized void set(int  msg , int count) {

        try{
            System.out.println("Waiting ................");
            Thread.sleep(400);
        }catch (Exception e){

        }
        while(valueSet){
            try{
                wait();
            }catch (Exception e){

            }
        }

        this.msg = msg;
        this.count = count;
        valueSet = true;
        notifyAll();
    }
    public synchronized void get(){

        try{
            Thread.sleep(1);
        }catch (Exception e){

        }
        while(!valueSet){
            try{
                wait();
            }catch (Exception e){

            }
        }
        System.out.println("Consume : " + msg);
        valueSet = false;
        notify();
    }
}


public class WaitDemo {
    public static void main(String[] args) {

        Data data = new Data();
        Thread process = new Thread(){
            @Override
            public void run() {
                for (int i=0 ; i<= 10 ; i++) {
                    for (int j = 1; j < 10; j++) {
                        data.set(i, j);

                    }
//
                }
            }
        };

        // Create consume thread
        Thread consume = new Thread(){
            @Override
            public void run() {
                for (int i=0 ; i<= 1000 ; i++){
                    data.get();
                }
            }
        };
        process.start();
        consume.start();

        try {
            process.join();
            consume.join();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
