package com.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Client {
    public static void main(String[] args) {
        // Create Hazelcast instance which is backed by a client
        HazelcastInstance client = HazelcastClient.newHazelcastClient();

        // Create a Hazelcast backed map
        Map<Integer, String> map = client.getMap("training");

        // Reading 20 elements
        readElements(map);

        // Now reading the same 20 elements again, this time they're already loaded
        readElements(map);
    }

    private static void readElements(Map<Integer, String> map) {
        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            String value = map.get(i);
            long required = System.currentTimeMillis() - start;
            System.out.println("Value '" + value + "' retrieved in " + required + " ms.");
        }
    }
}
