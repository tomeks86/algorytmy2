package com.company.algorytmy1a;

import java.util.*;

public class DataStructuresExercises {
    public static List<String> constructVeryLongList() { //Top secret implementation
        List<String> list = new ArrayList<>();
        final int HOW_MANY = 10000;
        Arrays.asList(new String[]{"STRING_1", "STRING_2", "STRING_3", "STRING_4"}).stream().forEach((item) -> {
            for (int i = 0; i < HOW_MANY; i++) {
                list.add(item);
            }
        });
        list.add("UNIQUE_1");
        list.add("UNIQUE_2");
        Collections.shuffle(list);
        return list;
    }

    public static ArrayList<String> sortList(List<String> stringList) {
        ArrayList<String> sorted = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String element = stringList.get(i);
            if (sorted.contains(element)) {
                continue;
            }
            int j = 0;
            while (j < sorted.size()) {
                if (element.compareTo(sorted.get(j)) > 0) j++;
                else break;
            }
            sorted.add(j, element);
        }
        return sorted;
    }

    public static void main(String[] args) {
        List<String> stringList = constructVeryLongList();
        ArrayList<String> sorted = sortList(stringList);
        System.out.println(stringList.toString());
        //System.out.println("STRING_3".compareTo("STRING_2"));
        //System.out.println(sorted.toString());
        //TreeSet<String> sorted2 = new TreeSet<>();
        TreeSet<String> sorted2 = new TreeSet<>(stringList);
        sorted2.addAll(stringList);
        if (sorted.size() < 20) {
            for (String s : sorted) {
                System.out.println(s);
            }
        }
    }

}
