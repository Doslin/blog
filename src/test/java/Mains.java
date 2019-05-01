import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mains  {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner =  new Scanner(System.in);
        int x = scanner.nextInt();
        int i = new Mains().NumberOf1_Solution3(x);
        System.out.println(i);
        ReentrantLock lock = new ReentrantLock(false);
        lock.lock();
        lock.unlock();
        Condition condition = lock.newCondition();
        condition.await();
        condition.signal();


    }
    int NumberOf1_Solution3(int i)
    {
        int count = 0;

        while (i >0)
        {
            ++ count;
            i = (i - 1) & i;
        }

        return count;
    }
}
