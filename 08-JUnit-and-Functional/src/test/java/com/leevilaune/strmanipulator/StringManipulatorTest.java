package com.leevilaune.strmanipulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringManipulatorTest {
    @Test
    void canConcatenate(){
        StringManipulator manipulator = new StringManipulator();
        assertEquals("concat", manipulator.concatenate("con","cat"));
        assertEquals("isstr", manipulator.concatenate("is","str"));
        assertEquals("",manipulator.concatenate(null,null));

    }
    @Test
    void canFindLength(){
        StringManipulator manipulator = new StringManipulator();
        assertEquals(6, manipulator.findLength("concat"));
        assertEquals(5, manipulator.findLength("isstr"));
        assertEquals(0,manipulator.findLength(""));
        assertEquals(0,manipulator.findLength(null));
    }
    @Test
    void canConvertToUppercase(){
        StringManipulator manipulator = new StringManipulator();
        assertEquals("CONCAT", manipulator.convertToUpperCase("concat"));
        assertEquals("ISSTR", manipulator.convertToUpperCase("iSStr"));
        assertEquals("",manipulator.convertToUpperCase(null));

    }
    @Test
    void canConvertToLowercase(){
        StringManipulator manipulator = new StringManipulator();
        assertEquals("concat", manipulator.convertToLowerCase("CONCAT"));
        assertEquals("isstr", manipulator.convertToLowerCase("isSTR"));
        assertEquals("",manipulator.convertToLowerCase(""));
        assertEquals("",manipulator.convertToLowerCase(null));

    }

    @Test
    void canFindSubstring(){
        StringManipulator manipulator = new StringManipulator();
        assertTrue(manipulator.containsSubstring("concat", "cat"));
        assertFalse(manipulator.containsSubstring("concat","foobar"));
        assertFalse(manipulator.containsSubstring("foo",null));
    }
}
