package com.bwardweb.helper;

public class StringHelper {
    public int countNumberOfChars(char charToCount, String input){
        int count = 0;
        for(int i=0;i<input.length();i++){
            if(input.charAt(i) == charToCount){
                count++;
            }
        }
        return count;
    }

}
