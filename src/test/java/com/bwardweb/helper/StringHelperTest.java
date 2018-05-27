package com.bwardweb.helper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
    StringHelper helper;

    @Before
    public void setup(){
        helper = new StringHelper();
    }

    @Test
    public void testCountNumberOfChars_emptyStringReturnsZero(){
        char c = 'a';
        String input = "";
        Assert.assertTrue(helper.countNumberOfChars(c, input) == 0);
    }

    @Test
    public void testCountNumberOfChars_validInputNoOccurences(){
        char c = 'a';
        String input = "hgfds";
        Assert.assertTrue(helper.countNumberOfChars(c, input) == 0);
    }

    @Test
    public void testCountNumberOfChars_validInputOneOccurence(){
        char c = 'a';
        String input = "hgfads";
        Assert.assertTrue(helper.countNumberOfChars(c, input) == 1);
    }

    @Test
    public void testCountNumberOfChars_validInputMultipleOccurences(){
        char c = 'a';
        String input = "ahgfadsa";
        Assert.assertTrue(helper.countNumberOfChars(c, input) == 3);
    }
}
