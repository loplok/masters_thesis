package org.example.flip;

import org.example.flip_utils.FlipTypes;

public class FlipZ extends GeneralFlip {

    public FlipZ(int length) {
        super(length);
        this.type = FlipTypes.ZFLIP;
    }
}
