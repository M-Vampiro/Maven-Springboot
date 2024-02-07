package com.vtxlab.bootcamp;


public class App 
{
    private String base;

    public String concat(String s) {
        if (this.base == null) 
        throw new IllegalArgumentException(); // round 2 refactoring
        return this.base.concat(s); // round 1 refactoring
    }

    public void setBase(String base) {
        this.base = base;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
