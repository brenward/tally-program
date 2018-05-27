package com.bwardweb.io;

import com.bwardweb.helper.StringHelper;

import java.util.Map;
import java.util.HashMap;

public class InputProcessor {

    private StringHelper helper;

    public InputProcessor(StringHelper helper){
        this.helper = helper;
    }

    public Map<String, Integer> processInputString(String input){
        Map<String, Integer> results = new HashMap<>();
        if(input == null){
            return results;
        }

        for(int i=0;i<input.length();i++){
            if(!results.containsKey(input.charAt(i))){
                int count = helper.countNumberOfChars(input.charAt(i),input);
                results.put(String.valueOf(input.charAt(i)),new Integer(count));
            }
        }

        return subtractCapitals(results);
    }

    private Map<String, Integer> subtractCapitals(Map<String, Integer> results){
        Map<String, Integer> combinedResults = new HashMap<>();
        for(String key:results.keySet()){
            char[] keyChar = key.toCharArray();
            if(Character.isUpperCase(keyChar[0])){
                String lowercaseString = String.valueOf(Character.toLowerCase(keyChar[0]));
                if( results.get(lowercaseString) != null) {
                    int lowercaseCount = results.get(lowercaseString);
                    int summedCount = lowercaseCount - results.get(key);
                    combinedResults.put(lowercaseString, new Integer(summedCount));
                }else{
                    combinedResults.put(lowercaseString, results.get(key) * -1);
                }
            }else{
                if(!combinedResults.containsKey(key)) {
                    combinedResults.put(key, results.get(key));
                }
            }
        }

        return combinedResults;
    }


}
