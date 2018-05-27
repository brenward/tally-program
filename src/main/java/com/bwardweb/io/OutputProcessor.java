package com.bwardweb.io;

import java.util.*;

public class OutputProcessor {
    public String createOutputResultsString(final Map<String,Integer> results){

        if(results == null){
            return "";
        }

        Set<Map.Entry<String,Integer>> sortedResults = sortOutput(results);

        StringBuilder stringBuilder = new StringBuilder();

        for(Map.Entry<String,Integer> result:sortedResults){
            stringBuilder.append(result.getKey());
            stringBuilder.append(":");
            stringBuilder.append(result.getValue());
            stringBuilder.append(", ");
        }

        return stringBuilder.toString();
    }

    public void outputResultsToConsole(String results){
        System.out.println(results);
    }

    private Set<Map.Entry<String,Integer>> sortOutput(final Map<String,Integer> results){
        SortedSet<Map.Entry<String,Integer>> sortedResults = new TreeSet<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o2.getValue().compareTo(o1.getValue()) == 0){
                            return o1.getKey().compareTo(o2.getKey());
                        }else {
                            return o2.getValue().compareTo(o1.getValue());
                        }
                    }
                }
        );

        sortedResults.addAll(results.entrySet());
        return sortedResults;
    }
}
