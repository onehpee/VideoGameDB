package org.example;



import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PracticeTest {

    @Test
    public void simpleTest1() {
        assertEquals(2, 2);
    }

    @Test
    public void simpleTest(){
        assertEquals("test", "test");
    }

    @Test
    public void simpleTest3() { assertEquals(3, 3);}

    @Test
    public void simpleTest4() {assertEquals(4, 2 + 3);}

}