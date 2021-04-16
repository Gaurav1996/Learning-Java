package com.gagrawal.practice.quick;

import java.util.*;

/**
 * @author Gaurav
 * 19/03/21
 */
public class MapUpdateTest {
    static Map<String, List<Integer>> map = new HashMap<>();
    public static void main(String[] args) {
        String key = "NUM";
        addToMap(key, Arrays.asList(1,2,3,4,5));
        addToMap(key, Arrays.asList(7,8,9,10));
        System.out.println(map);
    }

    private static void addToMap(String key, List<Integer> asList) {
        List<Integer> integers = map.get(key);
        if(integers == null) {
            integers = new ArrayList<>();
            map.put(key, integers);
        }
        integers.addAll(asList);
    }
}
