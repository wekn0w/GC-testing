package Heap;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * -XX:+UseG1GC -Xmx256m
 */
public class G1 {
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
        for (int i = 0; i < 100_000_000; i++) {
            TimeUnit.MILLISECONDS.sleep(10);
            new G1().insertIntegers();
            new G1().deleteIntegers();
        }
    }

    /*public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 100_000_000; i++) {
            if (i % 100_000 == 0) {
                TimeUnit.SECONDS.sleep(1);
            }
            String str = "" + random.nextInt();
            stringBuilder.append(str);
        }
    }*/
}
