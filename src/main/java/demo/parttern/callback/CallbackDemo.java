package demo.parttern.callback;

/**
 * 回调函数Demo
 */
public class CallbackDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我要休息了");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我被回调了");
            }
        });
        thread.start();
    }
}
