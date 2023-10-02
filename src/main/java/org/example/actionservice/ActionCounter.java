package org.example.actionservice;

import java.util.Map;
import java.util.TreeMap;

public class ActionCounter {
    private final TreeMap<Integer, Integer> callCounter = new TreeMap<>();

    public ActionCounter() {
    }

    public void call(int timestamp) {
        callCounter.merge(timestamp, 1, Integer::sum);
    }

    public int getActions(int timestamp) {
        return  callCounter.tailMap(timestamp - 299).entrySet()
                .stream()
                .filter( x -> x.getKey() <= timestamp)
                .map(Map.Entry::getValue)
                .reduce(Integer::sum).orElseThrow(ArithmeticException::new);
    }
}
