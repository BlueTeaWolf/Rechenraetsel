package de.hochtaunusschule;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;

import java.util.*;
/**
 * @author BlueTeaWolf
 */
public class DuplicateTracker<T> {
    private static final Random random = new Random();

    private final LongSet duplicatedResults = new LongOpenHashSet(100_000);
    private final Long2ObjectMap<T> results = new Long2ObjectOpenHashMap<>(100_000);

    public Map.Entry<Long, T> pickAny() {
        List<Map.Entry<Long, T>> allResults = new ArrayList<>(results.entrySet());
        return allResults.get(random.nextInt(allResults.size()));
    }

    public List<Map.Entry<Long, T>> pickAll() {
        List<Map.Entry<Long, T>> allResults = new ArrayList<>(results.entrySet());
        return allResults;
    }

    public void track(long result, T value) {
        if (duplicatedResults.contains(result)) {
            return;
        }
        if (results.put(result, value) != null) {
            results.remove(result);
            duplicatedResults.add(result);
        }
    }

    public Map<Long, T> getResults() {
        return results;
    }
}
