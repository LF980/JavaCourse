


public class Homework01 {
    static Object o1 = new Object();
    private static int result;

    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        Runnable rTask = new Runnable() {
            @Override
            public void run() {
                result = sum();
                synchronized (o1) {
                    o1.notifyAll();
                }
            }
        };

        try {
            Thread t = 	new Thread( rTask);
            t.start();
            synchronized (o1) {
                o1.wait();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");

    }



    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
