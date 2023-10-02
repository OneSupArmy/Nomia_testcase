package org.example.actionservice;

import java.util.Map;
import java.util.TreeMap;

public class ActionCounter {
    private final Map<Integer, Integer> callCounter = new TreeMap<>();

    public ActionCounter() {
    }

    public void call(int timestamp) {
        callCounter.put(timestamp, callCounter.getOrDefault(timestamp, 0) + 1);
    }

    public int getActions(int timestamp) {
            Integer result = 0;
            for (Map.Entry<Integer, Integer> integerIntegerEntry : callCounter.entrySet()) {
                    if (integerIntegerEntry.getKey() > timestamp - 300 && integerIntegerEntry.getKey() <= timestamp) {
                            result += integerIntegerEntry.getValue();
                    }
            }
        return result;
    }
}
