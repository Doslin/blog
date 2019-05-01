package thread;

import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10,
                2, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            poolExecutor.execute(myTask);
            System.out.println("线程池中线程数目 "+poolExecutor.getPoolSize()+" " +
                    ",队列中等待执行的任务数目："+poolExecutor.getQueue().size()
            +" ，已经执行完成的任务数目："+poolExecutor.getCompletedTaskCount());
        }
        poolExecutor.shutdown();

      Runnable task =   ()->{
            System.out.println("hello World!");
        };
      new Thread( ()->{
          System.out.println("hello World!");
      }).start();
    }
}
