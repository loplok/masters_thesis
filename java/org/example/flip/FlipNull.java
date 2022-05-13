package org.example.flip;

import org.example.flip_utils.FlipTypes;

public class FlipNull extends GeneralFlip{


    public FlipNull(Integer length) {
        super(length);
        this.type = FlipTypes.XFLIP;
    }
}
