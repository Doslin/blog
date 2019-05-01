import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main4 extends  Thread{


//    @Override
//    public void run(){
//        System.out.println("213432");
//    }
   public Main4(){

   }
    public Main4(Runnable s){
       s.run();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        int ss =9 ;
//          new Thread(new Runnable (){
//
//            @Override
//            public void run() {
//
//            }
//        }).start();
//        new Main4(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("3224");
//                System.out.println(currentThread().getId());
//            }
//        }).start();
        //System.out.println(Thread.activeCount());

        Future future = (Future) Executors.newFixedThreadPool(1).submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池的线程已经启动");
            }
        }).get();

    }



}
