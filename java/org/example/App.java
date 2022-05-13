package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Cube cube = new Cube(3);
        Scanner scn = new Scanner(System.in);


        FlipInterpreter interpret = new FlipInterpreter();
        interpret.interpret(cube, scn);
    }
}
