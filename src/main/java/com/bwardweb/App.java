package com.bwardweb;

import com.bwardweb.helper.StringHelper;
import com.bwardweb.io.InputProcessor;
import com.bwardweb.io.OutputProcessor;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        StringHelper helper = new StringHelper();
        InputProcessor inputProcessor = new InputProcessor(helper);
        OutputProcessor outputProcessor = new OutputProcessor();

        String inputOne = "abcde";
        String inputTwo = "dbbaCEDbdAacCEAadcB";

        Map<String,Integer> processedInput = inputProcessor.processInputString(inputOne);
        String processedOutput = outputProcessor.createOutputResultsString(processedInput);
        outputProcessor.outputResultsToConsole(processedOutput);

        processedInput = inputProcessor.processInputString(inputTwo);
        processedOutput = outputProcessor.createOutputResultsString(processedInput);
        outputProcessor.outputResultsToConsole(processedOutput);
    }
}
