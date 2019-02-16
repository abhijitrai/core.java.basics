package java.core.basics;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.*;

public class FebonacciFJ {
    /*
    Logic :
        1,1,2,3,5
         1 , 1
         f[1] = 1
         f[2] = 1
         f[3] = f[1] + f[2]
         f[4] = f[3] + f[2]
     */

    public static void main(String ... a) throws ExecutionException, InterruptedException {
       try{
           ForkJoinPool fjp = new ForkJoinPool();
           long index = 40;
           Instant start = Instant.now();
           Long result = fjp.invoke(new Fib(index));
           Instant end = Instant.now();
           fjp.shutdown();
//           System.out.println("Value : " + Period.between(end,start) );//Errors , period is between LocalDate
           System.out.println("Value : " + Duration.between(start,end).getSeconds());
           System.out.println("Fabonacci of " + index+ " is " + result);

       }
       catch(Exception e)
       {
           System.out.println("Exception : " + e);
       }

    }


    public static class Fib extends RecursiveTask<Long> {
        final long index ;

        public Fib(Long index){
            this.index = index;
        }

        public Long compute()  {
            if (index <= 2) {
//                System.out.println("["+Thread.currentThread().getName() + "]Fab of :" + index + "\t is " + index);
                return index;
            }
            ForkJoinTask<Long> oneBack = new Fib((long) (index -1));
            oneBack.fork();
            ForkJoinTask<Long> twoBack = new Fib((long) (index -2));
            twoBack.fork();
            long val = oneBack.join() + twoBack.join();
//            System.out.println("["+Thread.currentThread().getName() + "]Fab of :" + index + "\t is :" + val);

            return( val );

        }
    }

}
