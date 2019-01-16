package Utils;

import java.io.Serializable;

public class Coordinate implements Serializable {
    private int coordX;
    private int coordY;

    public Coordinate(int x, int y) {
        coordX = x;
        coordY = y;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    @Override
    public String toString() {
        return "[" + coordX + " " + coordY + "]";
    }
}
