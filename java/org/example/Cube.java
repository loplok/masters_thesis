package org.example;

import org.example.flip_utils.FlipUtils;

import java.util.ArrayList;

public class Cube implements ReversableCube {

    private int size;
    private ArrayList<ArrayList<ArrayList<String>>> list;

    private final int TILES_PER_FLOOR;
    private final int TILES_PER_ROW;
    private final int TILES_TOTAL;

    private FlipUtils utils;

    public Cube(int size) {
        this.size = size;
        this.TILES_TOTAL = size*size*size;
        this.TILES_PER_FLOOR = size*size;
        this.TILES_PER_ROW = size;

        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<ArrayList<String>>());
            for (int j = 0; j < size; j++) {
               list.get(i).add(new ArrayList<String>());
                for (int k = 0; k < size; k++) {
                    list.get(i).get(j).add(String.valueOf((i*TILES_PER_FLOOR) + j*3 + k + 1));
                }
            }
        }

        this.utils = new FlipUtils(this);
    }

    public int getTilesPerFloor() {
        return TILES_PER_FLOOR;
    }

    public int getTilesPerRow() {
        return TILES_PER_ROW;
    }

    public int getTotalTiles() {
        return TILES_TOTAL;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<ArrayList<ArrayList<String>>> getList() {
        return list;
    }

    @Override
    public String toString() {
        return null;
    }

    public void print() {
        System.out.println("Printing cube: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Floor " + i);
            for (int j = 0; j < size; j++) {
                System.out.println(list.get(i).get(j));
            }
            System.out.println();
        }
    }

    public void prettyPrint() {
        System.out.println("Printing cube: ");
        for (int i = size - 1; 0 <= i; i--) {
            System.out.println("Floor " + i);
            for (int j = size - 1; 0 <= j; j--) {
                System.out.println(list.get(i).get(j));
            }
            System.out.println();
        }
    }


    @Override
    public void xflip(int x) {
        if (x == 1) {
            utils.flipNthWall(0);
        } else {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < x/2; k++) {
                        String temp = list.get(i).get(j).get(k);
                        System.out.println("reversing " + temp + " " + getList().get(getSize() - i - 1).get(getSize() - j - 1).get(x - k - 1));
                        getList().get(i).get(j).set(k, getList().get(getSize() - i - 1).get(getSize() - j - 1).get(x - k - 1));
                        getList().get(getSize() - i - 1).get(getSize() - j - 1).set(x - k - 1, temp);
                    }
                }
            }
            if (x%2 != 0) {
                utils.flipNthWall(x/2);
            }
        }
    }

    @Override
    public void yflip(int y) {
        if (y == 1) {
            utils.flipNthFloorLikeMatrix(0);
        } else {
            for (int i = 0; i < y / 2; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < size; k++) {
                        String temp = list.get(i).get(j).get(k);
                        list.get(i).get(j).set(k, list.get(y - i - 1).get(size - j - 1).get(size - k - 1));
                        list.get(y - i - 1).get(size - j - 1).set(size - k - 1, temp);
                    }
                }
            }
            if (y%2 != 0) {
                utils.flipNthFloorLikeMatrix(y/2);
            }
        }
    }


    @Override
    public void zflip(int z) {
        if (z == 1) {
            utils.flipNthFront(0);
        } else {
            for (int j = 0; j < getSize(); j++) {               // y
                for (int i = 0; i < z/2; i++) {                 // z
                    for (int k = 0; k < getSize(); k++) {       // x
                        String temp = list.get(j).get(i).get(k);
                        getList().get(j).get(i).set(k, getList().get(getSize() - j - 1).get(z - i - 1).get(getSize() - k - 1));
                        getList().get(getSize() - j - 1).get(z - i - 1).set(getSize() - k - 1, temp);
                    }
                }
            }
            if (z%2 != 0) {
                utils.flipNthFront(z/2);
            }
        }
    }



}
