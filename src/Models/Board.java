package Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {

    private ArrayList<Segment> board = new ArrayList<>();

    public Board() {

    }

    public void addSegment(Segment s) {
        board.add(s);
    }

    public ArrayList<Segment> getSegments() {
        return board;
    }

    public int getFieldValue(int x, int y) {
        for(Segment s : board) {
            for (int i = 0; i < s.getSegment().length; i++) {
                Field f = s.getField(i);
                if (f.getCoordX() == x && f.getCoordY() == y) {
                    return f.getValue();
                }
            }
        }
        return 0;
    }

    public Field getField(int x, int y) {
        for(Segment s : board) {
            for (int i = 0; i < s.getSegment().length; i++) {
                Field f = s.getField(i);
                if (f.getCoordX() == x && f.getCoordY() == y) {
                    return f;
                }
            }
        }
        return new Field(0, 0, 0);
    }

    public int setFieldValue(int x, int y, int val) {
        for(Segment s : board) {
            for (int i = 0; i < s.getSegment().length; i++) {
                Field f = s.getField(i);
                if (f.getCoordX() == x && f.getCoordY() == y) {
                    if (val < 0) {
                        val = 15;
                    }
                    f.setValue(val % 16);
                    return f.getValue();
                }
            }
        }
        return 0;
    }

}