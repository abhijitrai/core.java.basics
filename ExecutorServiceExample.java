package java.core.basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceExample {

    static ExecutorServiceExample ese = new ExecutorServiceExample();
    private ExecutorServiceExample(){}

    public static void main (String... args){
        Thread.currentThread().setName("Abhijit's Main");
        System.out.println("The main Thread is : " + Thread.currentThread().getName());
        //Fixed Pool
        // Runtime.getRuntime().availableProcessors() -> 4
//        ese.executeOnThreadPool( Executors.newFixedThreadPool(8));
//        ese.executeOnThreadPool( Executors.newCachedThreadPool());
//        ese.executeOnThreadPool( Executors.newSingleThreadExecutor());

    }

    public void executeOnThreadPool(ExecutorService executorService){
        for(int i = 0; i<100;i++) {
            System.out.println("Submitted Task : " + i);
            executorService.submit(new PrimeNumberCounter());
        }
        executorService.shutdown();
    }
}

class PrimeNumberCounter implements Runnable{
    static AtomicInteger counter = new AtomicInteger();
    @Override
    public void run() {
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        long primeCount = 0 ;
        for(int i=0;i<9999;i++)
           if(isPrime(i))  primeCount++;
        System.out.println("The Prime count from Thread : " + Thread.currentThread().getName() + "\tEquals : " + primeCount );
    }

    public static boolean isPrime(long i)
    {
        boolean result = true;
        if(i>3){
            for(int j=2 ; j <= i/2 ; j++)
                if(Math.floorMod(i,j) == 0 )  result = false;
        }
        else {
            result = false;
        }
        return result;
    }
}
