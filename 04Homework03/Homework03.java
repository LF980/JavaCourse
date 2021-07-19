


public class Homework03 {
    private static int result;

    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        Runnable rTask =  new Runnable() {
            @Override
            public void run() {
                result = sum();
            }
        };

        Thread t1 =  new Thread(rTask);
        t1.start();

        while(true){
            if(result != 0){
                break;
            }
            try{
                Thread.sleep((long)0.1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
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
