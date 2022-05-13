package org.example.flip_utils;

import org.example.Cube;

import java.util.ArrayList;

public class FlipUtils {

    private Cube cube;

    public FlipUtils(Cube cube) {
        this.cube = cube;
    }

    public int getSize() {
        return cube.getSize();
    }

    public ArrayList<ArrayList<ArrayList<String>>> getList() {
        return cube.getList();
    }

    public void flipNthFloorLikeMatrix(int i) {
        for (int j = 0; j < getSize(); j++) {
            for (int k = 0; k < getSize(); k++) {
                if (j*cube.getTilesPerRow() + k < cube.getTilesPerFloor()/2) {
                    String temp = getList().get(i).get(j).get(k);
                    getList().get(i).get(j).set(k, getList().get(i).get(getSize() - j - 1).get(getSize() - k - 1));
                    getList().get(i).get(getSize() - j - 1).set(getSize() - k - 1, temp);
                }
            }
        }
    }

    public void flipNthFront(int i) {
        for (int j = 0; j < getSize(); j++) {
            for (int k = 0; k < getSize(); k++) {
                if (j * cube.getTilesPerRow() + k < cube.getTilesPerFloor() / 2) {
                    String temp = getList().get(j).get(i).get(k);
                    getList().get(j).get(i).set(k, getList().get(getSize() - j - 1).get(i).get(getSize() - k - 1));
                    getList().get(getSize() - j - 1).get(i).set(getSize() - k - 1, temp);
                }
            }
        }
    }

    public void flipNthWall(int nthWall) {
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                    if (i * cube.getTilesPerRow() + j < cube.getTilesPerFloor() / 2) {
                        String temp = getList().get(i).get(j).get(nthWall);
                        getList().get(i).get(j).set(nthWall, getList().get(getSize() - i - 1).get(getSize() - j - 1).get(nthWall));
                        getList().get(getSize() - i - 1).get(getSize() - j - 1).set(nthWall, temp);
                    }
                }
        }
    }
}
