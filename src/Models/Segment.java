package Models;

import java.io.Serializable;

public class Segment implements Serializable {

    private Field[] segment;
    private int segmentValue;

    public Segment(){
//        segment = new ArrayList<>();
    }

    public void setSegmentValue(int segmentValue) {
        this.segmentValue = segmentValue;
    }

    public int getSegmentValue() {
        return segmentValue;
    }

    public Field[] getSegment() {
        return segment;
    }

    public void setSegment(Field[] segment) {
        this.segment = segment;
        setSegmentValue(segment[0].getValue());
    }
    public int getSizeOfSegment() {
        return segment.length;
    }

    public Field getField(int index) {
        return segment[index];
    }
    public String toString() {
        String s = "";
        for (int i = 0; i < segment.length; i++) {
            s += segment[i] + " ";
        }
        return s;
    }
}
