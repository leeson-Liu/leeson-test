package lock;

/**
 * @author liubin
 * @create 2019-07-22 17:22
 * @desc ${DESCRIPTION}
 **/
public class ThreadDemo implements Runnable {

    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadDemo());
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        synchronized (ThreadDemo.class) {
            for (int i = 0; i < 1000000; i++)
                count++;
        }
    }

}
