package java.core.basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class Locks {


    public static void main(String... args) {
        SharedResource sr = new SharedResource();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Accessor("Accessor : " + i, sr));
        }
        executorService.shutdown();
    }

    static class Accessor implements Runnable {
        SharedResource sr = null;
        String name;

        Accessor(String name, SharedResource sr) {
            this.name = name;
            this.sr = sr;
        }

        @Override
        public void run() {
            boolean read = false;
            boolean wrote = false;
            do {
                try {

                    if (!wrote) {
                        Thread.sleep(10);
                        wrote = sr.setAccessingThreadName(name);

                    }
                    if (!read) {
                        Thread.sleep(10);
                        read = sr.getAccessingThreadName();

                    }
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            while (!read || !wrote);
        }
    }

}


class SharedResource {
    SynchronousQueue<String> sq = new SynchronousQueue<>();
    public boolean setAccessingThreadName(String accessingThreadName) throws InterruptedException {
        boolean success = sq.offer(accessingThreadName, 5, TimeUnit.MILLISECONDS);
        if (success)
            System.out.println("Name set to : " + accessingThreadName);
        return success;
    }

    public boolean getAccessingThreadName() throws InterruptedException {
        String val = sq.poll(5, TimeUnit.MILLISECONDS);
        boolean success = val != null;
        if (success) System.out.println("Name returned : " + val);
        return success;
    }
}
