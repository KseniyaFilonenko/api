package com.itacademy;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PrinterTest {
    //int a a % 2 = 0 -> 3
    //int a a % 5 = 0 -> 5
    @Test
    public void firstTest() {
        Printer printer = new Printer();
        String result = printer.print(3);
        assertEquals(result, "Three");
    }
    @Test
    public void secondTest() {
        Printer printer = new Printer();
        String result = printer.print(5);
        assertEquals(result, "Five");
    }
    @Test
    public void thirdTest() {
        Printer printer = new Printer();
        String result = printer.print(7);
        assertEquals(result, "7");
    }
}
