package com.gagrawal.practice.nonaccessmodifiers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StaticExampleTest {
    @Test
    void testStaticVsNormalVariable() {
        assertEquals(0,StaticExample.staticInt);
        StaticExample object1 = new StaticExample();
        assertEquals(1,object1.staticInt);
        assertEquals(1,object1.normalInt);
        StaticExample object2 = new StaticExample();
        assertEquals(2,object2.staticInt);
        assertEquals(1,object2.normalInt);
        //change object1 state and see that object2 gets reflected in case of static and object2 remains 1 in case of normal
        object1.staticInt = 10;
        object1.normalInt = 10;
        assertEquals(10, object2.staticInt);
        assertEquals(1, object2.normalInt);
    }
    @Test
    void testStaticBlock() {
        //Note that this testcase would fail when run along with the previous test case.
        //Because static block would be executed only once(which happens already in the previous test cases)
        // and when run with other test case the static block wont be called and the static block message wont be printed
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        setUpStreams(outContent);
        //test cases
        StaticExample object1 = new StaticExample();
        assertEquals("Hello from static block 1\nHello from static block 2\nHello from constructor!\n",outContent.toString());
        restoreStreams(originalOut);
    }
    void setUpStreams(ByteArrayOutputStream outContent) {
        System.setOut(new PrintStream(outContent));
    }
    void restoreStreams(PrintStream originalOut) {
        System.setOut(originalOut);
    }
}
