package Utils;

import java.io.Serializable;

public class FriendlyField implements Serializable {
    private int val;
    private Coordinate coord;
    private boolean isEditable;

    public FriendlyField(int val, Coordinate coord, boolean isEditable) {
        this.val = val;
        this.coord = coord;
        this.isEditable = isEditable;
    }

    public int getVal() {
        return val;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return coord.toString() + " " + val;
    }
}
