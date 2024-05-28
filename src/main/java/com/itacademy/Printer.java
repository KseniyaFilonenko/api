package com.itacademy;

public class Printer {
    public String print(int a){
        if (a % 3 == 0)
            return "Three";
        else if (a % 5 == 0)
            return "Five";
        else
            return String.valueOf(a);
    }
}
