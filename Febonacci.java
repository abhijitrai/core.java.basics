package java.core.basics;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.concurrent.*;

public class Febonacci {
    /*
    Logic :
        1,1,2,3,5
         1 , 1
         f[1] = 1
         f[2] = 1
         f[3] = f[1] + f[2]
         f[4] = f[3] + f[2]
     */

    public static void main(String... a) throws ExecutionException, InterruptedException {
        try {
            ExecutorService es = Executors.newFixedThreadPool(8);
            int index = 10;
            Instant start = Instant.now();
            long val = fib(index);
            Instant end = Instant.now();
            es.shutdown();
            System.out.println("Fenobacci of :" + index + "\t is :" + val);
            System.out.println("Value : " + Duration.between(start,end).getSeconds());
        } catch (Exception e) {
            System.out.println("Exception : " + e);
        }

    }

    private static long fib(int index){
        if(index <= 2 )
            return index ;
        return fib(index -1 ) +  fib(index -2 );
    }



}
