package com.bwardweb.io;

import com.bwardweb.helper.StringHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InputProcessorTest {
    InputProcessor processor;
    StringHelper helper;

    @Before
    public void setup(){
        helper = new StringHelper();
        processor = new InputProcessor(helper);
    }

    @Test
    public void testProcessInputString_nullInput(){
        String input = null;
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(result != null);
    }

    @Test
    public void testProcessInputString_validInputResultNotEmpty(){
        String input = "abc";
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(!result.isEmpty());
    }

    @Test
    public void testProcessInputString_validInputResultContainsOneValue(){
        String input = "a";
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(result.size() == 1);
    }

    @Test
    public void testProcessInputString_validInputResultContainsTwoValues(){
        String input = "ab";
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(result.size() == 2);
    }

    @Test
    public void testProcessInputString_validInputResultContainsMultipleValues(){
        String input = "abc";
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(result.size() == 3);
    }

    @Test
    public void testProcessInputString_validInputResultContainsCorrectCounts(){
        String input = "abacab";
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(result.get("a") == 3
                && result.get("b") == 2
                && result.get("c") == 1);
    }

    @Test
    public void testProcessInputString_validInputResultContainsCorrectCountsWithNegatives(){
        String input = "abaAcabADdE";
        Map<String,Integer> result = processor.processInputString(input);
        Assert.assertTrue(result.get("a") == 1
                && result.get("b") == 2
                && result.get("c") == 1
                && result.get("d") == 0
                && result.get("e") == -1);
    }
}
