package Metaspace;

import Heap.G1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * -XX:MaxMetaspaceSize=1m
 */
public class ParallelGC {
     public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        //Lead to OutOfMemoryError Metaspace
        for (int i = 0; i < 100_000_000; i++) {
            objectList.add(new Object());
        }
    }
}
