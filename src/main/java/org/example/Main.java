package org.example;

import TestBase.environmentConfig;

public class Main {
    public static void main( String[] args ) {
        System.out.println( "Hello world!" );
        new environmentConfig().setenvironmentDetails();
    }
}