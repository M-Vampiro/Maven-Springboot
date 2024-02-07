package com.vtxlab.bootcamp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testConcat() {
        String base = "hello";
        App app = new App();
        app.setBase(base);
        assertEquals("helloworld", app.concat("world"));
    }
    @Test
    public void testConcat2() {
        String base = null;
        App app = new App();
        app.setBase(base);
        // assertEquals("helloworld", app.concat("world"));
        assertThrows(IllegalArgumentException.class , () -> app.concat("world"));
    }
}
