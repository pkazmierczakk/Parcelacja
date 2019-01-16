package Utils;

import java.io.Serializable;

public class MoveOfPlayer implements Serializable {
    private Coordinate coord;
    private int prevValue;
    private int currentValue;

    public MoveOfPlayer(Coordinate coord, int prevVal, int currentValue) {
        this.coord = coord;
        this.prevValue = prevVal;
        this.currentValue = currentValue;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public int getPrevValue() {
        return prevValue;
    }

    public void setPrevValue(int prevValue) {
        this.prevValue = prevValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }
}
