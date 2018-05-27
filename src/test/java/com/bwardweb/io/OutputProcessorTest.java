package com.bwardweb.io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class OutputProcessorTest {
    OutputProcessor outputProcessor;

    @Before
    public void setup(){
        outputProcessor = new OutputProcessor();
    }

    @Test
    public void testcreateOutputResultsString_nullResults(){
        HashMap<String,Integer> testResults= null;
        String resultString =outputProcessor.createOutputResultsString(testResults);

        Assert.assertTrue(resultString.equals(""));
    }

    @Test
    public void testcreateOutputResultsString_emptyResults(){
        HashMap<String,Integer> testResults= new HashMap<>();
        String resultString =outputProcessor.createOutputResultsString(testResults);

        Assert.assertTrue(resultString.equals(""));
    }

    @Test
    public void testcreateOutputResultsString_validInput(){
        HashMap<String,Integer> testResults= new HashMap<>();
        testResults.put("a",2);
        testResults.put("b",1);
        testResults.put("c",3);
        String resultString =outputProcessor.createOutputResultsString(testResults);

        Assert.assertTrue(resultString.equals("c:3, a:2, b:1, "));
    }

}
