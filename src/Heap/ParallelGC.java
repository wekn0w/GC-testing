package Heap;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * -XX:+UseParallelGC -Xmx256m
 */
public class ParallelGC {
    //Excessive usage of static fields can potentially lead to a memory leak
    private static LinkedList<Integer> integers = new LinkedList<>();

    public void insertIntegers() {
        for (int i = 0; i < 1000; i++) {
            integers.add(new Random().nextInt());
        }
    }

    public void deleteIntegers() {
        for (int i = 0; i < 700; i++) {
            integers.poll();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //java.lang.OutOfMemoryError: GC overhead limit exceeded
        for (int i = 0; i < 100_000_000; i++) {
            TimeUnit.MILLISECONDS.sleep(10);
            new ParallelGC().insertIntegers();
            new ParallelGC().deleteIntegers();
        }
    }
}
