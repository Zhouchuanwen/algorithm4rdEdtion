/**
 * Created by alan on 16/12/9.
 */
public class DeadLock {

    private final Object left=new Object();
    private final Object right=new Object();


    public void leftRight() throws InterruptedException {
        synchronized (left){
            Thread.sleep(2000);
            synchronized (right){
                System.out.println("left got right!");
            }
        }
    }

    public void rightLeft() throws InterruptedException {
        synchronized (right){
            Thread.sleep(2000);
            synchronized (left){
                System.out.println("right got left!");
            }
        }
    }



    public static class Thread1 extends Thread{
        private DeadLock dl;

        public Thread1(DeadLock dl) {
            this.dl = dl;
        }

        public void run() {
            try {
                dl.leftRight();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static class Thread2 extends Thread{
        private DeadLock dl;

        public Thread2(DeadLock dl) {
            this.dl = dl;
        }

        public void run() {
            try {
                dl.rightLeft();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //线程死锁实现...
    public static void main(String[] args){
        DeadLock dl = new DeadLock();
        Thread1 t1 = new Thread1(dl);
        Thread2 t2 = new Thread2(dl);
        t1.start();
        t2.start();
    }
}
