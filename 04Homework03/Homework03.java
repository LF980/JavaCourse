package java0.conc0303;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 extends Thread
{
    private int x;
    public int answer;

    public Homework03(int x) {
        this.x = x;
    }

    public void run() {
        if( x <= 2 )
            answer = 1;
        else {
            try {
                Homework03 f1 = new Homework03(x-1);
                Homework03 f2 = new Homework03(x-2);
                f1.start();
                f2.start();
                f1.join();
                f2.join();
                answer = f1.answer + f2.answer;
            }
            catch(InterruptedException ex) { }
        }
    }

    public static void main(String[] args)
            throws Exception
    {
        try {
            Homework03 f = new Homework03( 4 );
            f.start();
            f.join();
            System.out.println(f.answer);
        }
        catch(Exception e) {
            System.out.println("usage: java Fib NUMBER");
        }
    }
}
