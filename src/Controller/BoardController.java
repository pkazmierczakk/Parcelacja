package Controller;

import Models.Board;
import Models.Field;
import Models.Segment;
import Utils.Coordinate;
import Utils.FriendlyField;
import Utils.MoveOfPlayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class BoardController implements Serializable {

    private Board board = new Board();
    private int size = 9;
    private int minVal = 1;
    private int maxVal = 15;
    private FriendlyField[][] readyBoard;
    private ArrayList<MoveOfPlayer> undoMoves = new ArrayList<>();
    private ArrayList<MoveOfPlayer> redoMoves = new ArrayList<>();

    public BoardController(){
        generateBoard();
    }

    public FriendlyField[][] getBoard() {
        FriendlyField[][]readyBoard = new FriendlyField[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                Field f = board.getField(x,y);
                FriendlyField ff = new FriendlyField(f.getValue(), new Coordinate(f.getCoordX(), f.getCoordY()), f.isEditable());
                readyBoard[y][x] = ff;
            }
        }
        return readyBoard;
    }

    private void generateBoard(){
        Field[][] rawBoard;
        rawBoard = new Field[size][];
        int y = 0;
        rawBoard[y] = new Field[]{
                new Field(0,y, 8),
                new Field(1,y, 8),
                new Field(2,y, 2),
                new Field(3,y, 2),
                new Field(4,y, 6),
                new Field(5,y, 6),
                new Field(6,y, 6),
                new Field(7,y, 4),
                new Field(8,y, 4)};
        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 8),
                new Field(1,y, 8),
                new Field(2,y, 4),
                new Field(3,y, 4),
                new Field(4,y, 6),
                new Field(5,y, 6),
                new Field(6,y, 6),
                new Field(7,y, 4),
                new Field(8,y, 4)};
        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 8),
                new Field(1,y, 8),
                new Field(2,y, 4),
                new Field(3,y, 4),
                new Field(4,y, 5),
                new Field(5,y, 5),
                new Field(6,y, 5),
                new Field(7,y, 5),
                new Field(8,y, 5)};

        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 8),
                new Field(1,y, 8),
                new Field(2,y, 6),
                new Field(3,y, 6),
                new Field(4,y, 6),
                new Field(5,y, 6),
                new Field(6,y, 6),
                new Field(7,y, 6),
                new Field(8,y, 4)};

        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 10),
                new Field(1,y, 10),
                new Field(2,y, 10),
                new Field(3,y, 10),
                new Field(4,y, 10),
                new Field(5,y, 9),
                new Field(6,y, 9),
                new Field(7,y, 9),
                new Field(8,y, 4)};

        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 10),
                new Field(1,y, 10),
                new Field(2,y, 10),
                new Field(3,y, 10),
                new Field(4,y, 10),
                new Field(5,y, 9),
                new Field(6,y, 9),
                new Field(7,y, 9),
                new Field(8,y, 4)};

        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 5),
                new Field(1,y, 5),
                new Field(2,y, 5),
                new Field(3,y, 5),
                new Field(4,y, 5),
                new Field(5,y, 9),
                new Field(6,y, 9),
                new Field(7,y, 9),
                new Field(8,y, 4)};

        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 8),
                new Field(1,y, 8),
                new Field(2,y, 8),
                new Field(3,y, 8),
                new Field(4,y, 10),
                new Field(5,y, 10),
                new Field(6,y, 10),
                new Field(7,y, 10),
                new Field(8,y, 10)};

        y++;
        rawBoard[y] = new Field[]{
                new Field(0,y, 8),
                new Field(1,y, 8),
                new Field(2,y, 8),
                new Field(3,y, 8),
                new Field(4,y, 10),
                new Field(5,y, 10),
                new Field(6,y, 10),
                new Field(7,y, 10),
                new Field(8,y, 10)};
        Segment s1 = new Segment();
        s1.setSegment(new Field[]{rawBoard[0][0], rawBoard[0][1], rawBoard[1][0], rawBoard[1][1], rawBoard[2][0], rawBoard[2][1], rawBoard[3][0], rawBoard[3][1]});
        board.addSegment(s1);

        Segment s2 = new Segment();
        s2.setSegment(new Field[]{rawBoard[0][2], rawBoard[0][3]});
        board.addSegment(s2);

        Segment s3 = new Segment();
        s3.setSegment(new Field[]{rawBoard[0][4], rawBoard[0][5], rawBoard[0][6], rawBoard[1][4], rawBoard[1][5], rawBoard[1][6]});
        board.addSegment(s3);

        Segment s4 = new Segment();
        s4.setSegment(new Field[]{rawBoard[0][7], rawBoard[0][8], rawBoard[1][7], rawBoard[1][8]});
        board.addSegment(s4);

        Segment s5 = new Segment();
        s5.setSegment(new Field[]{rawBoard[1][2], rawBoard[1][3], rawBoard[2][2], rawBoard[2][3]});
        board.addSegment(s5);

        Segment s6 = new Segment();
        s6.setSegment(new Field[]{rawBoard[2][4], rawBoard[2][5], rawBoard[2][6], rawBoard[2][7], rawBoard[2][8]});
        board.addSegment(s6);

        Segment s7 = new Segment();
        s7.setSegment(new Field[]{rawBoard[3][2], rawBoard[3][3], rawBoard[3][4], rawBoard[3][5], rawBoard[3][6], rawBoard[3][7]});
        board.addSegment(s7);

        Segment s8 = new Segment();
        s8.setSegment(new Field[]{rawBoard[3][8], rawBoard[4][8], rawBoard[5][8], rawBoard[6][8]});
        board.addSegment(s8);

        Segment s9 = new Segment();
        s9.setSegment(new Field[]{rawBoard[4][0], rawBoard[4][1], rawBoard[4][2], rawBoard[4][3], rawBoard[4][4], rawBoard[5][0], rawBoard[5][1], rawBoard[5][2], rawBoard[5][3], rawBoard[5][4]});
        board.addSegment(s9);

        Segment s10 = new Segment();
        s10.setSegment(new Field[]{rawBoard[4][5], rawBoard[4][6], rawBoard[4][7], rawBoard[5][5], rawBoard[5][6], rawBoard[5][7], rawBoard[6][5], rawBoard[6][6], rawBoard[6][7]});
        board.addSegment(s10);

        Segment s11 = new Segment();
        s11.setSegment(new Field[]{rawBoard[6][0], rawBoard[6][1], rawBoard[6][2], rawBoard[6][3], rawBoard[6][4]});
        board.addSegment(s11);

        Segment s12 = new Segment();
        s12.setSegment(new Field[]{rawBoard[7][0], rawBoard[7][1], rawBoard[7][2], rawBoard[7][3], rawBoard[8][0], rawBoard[8][1], rawBoard[8][2], rawBoard[8][3]});
        board.addSegment(s12);
//        System.out.println("fsafd" + s12);

        Segment s13 = new Segment();
        s13.setSegment(new Field[]{rawBoard[7][4], rawBoard[7][5], rawBoard[7][6], rawBoard[7][7], rawBoard[7][8], rawBoard[8][4], rawBoard[8][5], rawBoard[8][6], rawBoard[8][7], rawBoard[8][8]});
        board.addSegment(s13);


        ArrayList<Segment> segments = board.getSegments();
        Random random = new Random();
        FriendlyField [][] readyBoard = new FriendlyField[size][size];
        for (Segment segment : segments) {
            int randomFieldIndex = random.nextInt(segment.getSizeOfSegment());
            for (int i = 0; i < segment.getSegmentValue(); i++) {
                Field f = segment.getField(i);
                if (randomFieldIndex != i) {
                    f.setValue(0);
                } else {
                    f.setEditable(false);
                }
            }
        }
    }

    public int getFieldValue(Coordinate coord) {
        return board.getFieldValue(coord.getCoordX(), coord.getCoordY());
    }


    public int addToFieldAndReturn(Coordinate coord, int val) {
        int currentValue = board.getFieldValue(coord.getCoordX(), coord.getCoordY());
        int newValue = board.setFieldValue(coord.getCoordX(), coord.getCoordY(), val+currentValue);
        undoMoves.add(new MoveOfPlayer(coord ,currentValue, newValue));
        redoMoves.clear();
        return newValue;
    }
    public int setFieldValueAndReturn(Coordinate coord, int val) {
        undoMoves.add(new MoveOfPlayer(coord ,getFieldValue(coord), val));
        redoMoves.clear();
        return board.setFieldValue(coord.getCoordX(), coord.getCoordY(), val);
    }

    public MoveOfPlayer getUndoMove() {
        if (undoMoves.size() <= 0) {
            return null;
        }
        MoveOfPlayer move = undoMoves.get(undoMoves.size() - 1);
        undoMoves.remove(move);
        redoMoves.add(move);
        board.setFieldValue(move.getCoord().getCoordX(), move.getCoord().getCoordY(), move.getPrevValue());
        return move;
    }

    public MoveOfPlayer getRedoMove() {
        if (redoMoves.size() <= 0) {
            return null;
        }
        MoveOfPlayer move = redoMoves.get(redoMoves.size() - 1);
        redoMoves.remove(move);
        undoMoves.add(move);
        board.setFieldValue(move.getCoord().getCoordX(), move.getCoord().getCoordY(), move.getCurrentValue());
        return move;
    }

    public boolean checkSolution() {
        class SolutionFieldHelper {
            private boolean isEditable;
            private boolean isVisited;
            private int value;

            SolutionFieldHelper(boolean isEditable, int value) {
                this.isEditable = isEditable;
                this.value = value;
                this.isVisited = false;
            }

            public void setVisited(boolean visited) {
                isVisited = visited;
            }

            public boolean isEditable() {
                return isEditable;
            }

            public boolean isVisited() {
                return isVisited;
            }

            public int getValue() {
                return value;
            }
        }

        class CheckSegment {
            private SolutionFieldHelper [][] board;
            private int size;
            private int expectedNumberOfField = 0;
            private int currentNumbersOfFields = 0;
            private int valueToCheck;

            CheckSegment(SolutionFieldHelper [][] board, int x, int y, int size) {
                this.board = board;
                this.size = size;
                this.valueToCheck = board[y][x].getValue();
                check(x,y);
            }

            private void check(int x, int y) {
                SolutionFieldHelper currentField = board[y][x];
                currentNumbersOfFields++;
                if (!currentField.isEditable()) {
                    expectedNumberOfField += currentField.getValue();
                }
                currentField.setVisited(true);

                if (y > 0 && !board[y-1][x].isVisited() && board[y-1][x].getValue() == valueToCheck) { // UP
                    check(x, y-1);
                }
                if (x < (size-1) && !board[y][x+1].isVisited() && board[y][x+1].getValue() == valueToCheck) { // RIGHT
                    check(x+1, y);
                }

                if (y < (size-1) && !board[y+1][x].isVisited() && board[y+1][x].getValue() == valueToCheck) { // DOWN
                    check(x, y+1);
                }

                if (x > 0 && !board[y][x-1].isVisited() && board[y][x-1].getValue() == valueToCheck) { // LEFT
                    check(x-1, y);
                }

            }

            public boolean isSegmentValid() {
                return expectedNumberOfField == currentNumbersOfFields;
            }
        }

        SolutionFieldHelper [][]tempBoard = new SolutionFieldHelper[size][size];

        for(Segment s : board.getSegments()) {
            int segmentSize = s.getSizeOfSegment();
            for (int i = 0; i < segmentSize; i++) {
                Field f = s.getField(i);
                tempBoard[f.getCoordY()][f.getCoordX()] = new SolutionFieldHelper(f.isEditable(), f.getValue());
            }
        }

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (!tempBoard[y][x].isVisited()) {
                    CheckSegment checkSegment = new CheckSegment(tempBoard, x, y, size);
                    if (!checkSegment.isSegmentValid()) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
