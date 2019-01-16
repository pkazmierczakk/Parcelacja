package Models;

import java.io.Serializable;

public class Field implements Serializable {

    private int coordX;
    private int coordY;
    private int value;
    private boolean isEditable = true;

    public Field (int x, int y){
        coordX = x;
        coordY = y;
        value = 0;
    }
    public Field (int x, int y, int val){
        coordX = x;
        coordY = y;
        value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
