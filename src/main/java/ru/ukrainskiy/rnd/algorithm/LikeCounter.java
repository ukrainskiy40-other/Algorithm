package ru.ukrainskiy.rnd.algorithm;


import java.util.HashMap;
import java.util.Map;

class LikeCounter {

    private final Map<Long, Integer> counter = new HashMap<>();

    private int max = 0;

    public void like(Long userId) {
        if (counter.containsKey(userId)) {
            counter.put(userId, counter.get(userId) + 1);
        } else {
            counter.put(userId, 1);
        }
        if (max < counter.get(userId)) {
            max = counter.get(userId);
        }
    }

    public void unLike(Long userId) {
        if (counter.containsKey(userId)) {
            int i = counter.get(userId);
            if (i > 1) {
                counter.put(userId, i - 1);
            } else {
                counter.put(userId, 0);
            }
        }
        max = counter.values().stream().max(Integer::compareTo).orElse(0);
    }

    public int getMax() {

        return Math.max(max, 0);
    }
}