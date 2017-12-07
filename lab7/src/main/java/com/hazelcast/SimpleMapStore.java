package com.hazelcast;

import com.hazelcast.core.MapStore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SimpleMapStore implements MapStore<Integer, String> {
    private final DummyDatabase database = new DummyDatabase();

    public void store(Integer key, String value) {
        System.out.println("Informational: store called");
    }

    public void storeAll(Map<Integer, String> entries) {
        System.out.println("Informational: storeAll called");
    }

    public void delete(Integer key) {
        System.out.println("Informational: delete called");
    }

    public void deleteAll(Collection<Integer> keys) {
        System.out.println("Informational: deleteAll called");
    }

    public String load(Integer key) {
        System.out.println("Informational: load called");
        // Create the value and return it from the load method
        return database.select(key);
    }

    public Map<Integer, String> loadAll(Collection<Integer> keys) {
        System.out.println("Informational: loadAll called");
        Map<Integer, String> result = new HashMap<>();
        for (Integer key : keys) {
            result.put(key, load(key));
        }
        return result;
    }

    public Iterable<Integer> loadAllKeys() {
        System.out.println("Informational: loadAllKeys called");
        // Can be used to pre-populate known keys
        return null;
    }
}
