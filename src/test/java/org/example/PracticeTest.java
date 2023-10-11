package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeTest {

    @Test
    public void simpleTest1() {
        assertEquals(2, 2);
    }

    @Test
    public void simpleTest(){
        assertEquals("test", "test");
    }

}