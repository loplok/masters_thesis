package org.example;

import org.example.flip.*;

import java.util.Scanner;

public class FlipInterpreter {

    private String lastLineExecuted;
    private Cube cube;

    public FlipInterpreter(){
        this.lastLineExecuted = "";
    }

    public void interpret(Cube cube, Scanner scanner) {
        while (scanner.hasNext()) {
            String toInterpret = scanner.nextLine();
            if (toInterpret.split(" ").length == 2) {
                String flipAxis = toInterpret.split(" ")[0];
                int length = Integer.parseInt(toInterpret.split(" ")[1]);
                GeneralFlip flip;
                if (flipAxis.equals("z")) {
                    flip = new FlipZ(length);
                } else if (flipAxis.equals("x")) {
                    flip = new FlipX(length);
                } else if (flipAxis.equals("y")) {
                    flip = new FlipY(length);
                }
                else {
                    // Should not happen, safety measures basically
                    flip = new FlipNull(null);
                }
                // save as last executed
                this.cube = cube;
                this.lastLineExecuted = toInterpret;
                // go on to execute the interpreted text
                execute(cube, flip);
            } else if (toInterpret.split(" ").length == 1) {
                if (toInterpret.equals("reset")) {
                    cube = new Cube(cube.getSize());
                    System.out.println("Reset the cube to its basic position");
                } else if (toInterpret.equals("print")) {
                    cube.prettyPrint();
                }
            }

        }
    }

    private void execute(Cube cube, GeneralFlip flipDescription) {
            switch (flipDescription.getType()) {
                case XFLIP:
                    cube.xflip(flipDescription.getLength());
                    break;
                case ZFLIP:
                    cube.zflip(flipDescription.getLength());
                    break;
                case YFLIP:
                    cube.yflip(flipDescription.getLength());
                    break;
                default:
                    break;
            }
            cube.prettyPrint();
    }

}
