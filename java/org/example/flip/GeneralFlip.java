package org.example.flip;

import org.example.flip_utils.FlipTypes;

public class GeneralFlip {

    public FlipTypes type;
    public int length;

    public GeneralFlip(int length) {
        this.length = length;
    }

    public FlipTypes getType() {
        return type;
    }

    public void setType(FlipTypes type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
