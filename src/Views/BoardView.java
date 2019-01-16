package Views;


import Controller.BoardController;
import Utils.FriendlyField;
import Utils.MoveOfPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardView extends JComponent {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private BoardButton[][] boardButtons;
    private BoardController boardController;
    BoardView(BoardController boardController) {
        this.boardController = boardController;
        setLayout(new GridLayout(9,9, 0,0));
        setBoardController(boardController);
    }

    public void generateView() {
        removeAll();
        FriendlyField[][] board = boardController.getBoard();
        boardButtons = new BoardButton[board.length][board.length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                FriendlyField f = board[y][x];
                System.out.println(f);
                BoardButton boardBtn = new BoardButton(f.getVal(), f);
                if (!f.isEditable()) {
                    boardBtn.setEnabled(false);
                } else {
                    boardBtn.addMouseListener(new ClickBoardButtonListener(f.getVal()));
                }
                boardBtn.decorateButton();
                boardButtons[y][x] = boardBtn;
                boardBtn.setBackground(f.getVal());
                add(boardBtn);
            }
        }
        System.out.println("---------------");
//        repaint();
        revalidate(); // Trzeba to wykonac aby zaktualizowac plansze
    }

    public void setBoardController(BoardController boardController) {
        this.boardController = boardController;
        generateView();
    }

    public void undoMove() {
        MoveOfPlayer move = boardController.getUndoMove();
        if (move == null) {
            return;
        }
        boardButtons[move.getCoord().getCoordY()][move.getCoord().getCoordX()].setText(move.getPrevValue());
    }

    public void redoMove() {
        MoveOfPlayer move = boardController.getRedoMove();
        if (move == null) {
            return;
        }
        System.out.println("redoMove -> " + move + " " + move.getCoord() + " " + move.getCurrentValue());
        boardButtons[move.getCoord().getCoordY()][move.getCoord().getCoordX()].setText(move.getCurrentValue());
    }

    public boolean checkSolution() {
        return boardController.checkSolution();
    }

    private class ClickBoardButtonListener implements MouseListener {
        private int value;
        ClickBoardButtonListener(int val) {
            value = val;
        }

        @Override
        public void mousePressed(MouseEvent evt) {
            BoardButton btn = (BoardButton)evt.getSource();
            if (evt.getButton() == MouseEvent.BUTTON1) {
                value+=2;
             } else if (evt.getButton() == MouseEvent.BUTTON3) {
                value--;
            }

            value = boardController.setFieldValueAndReturn(btn.getCoords(), value);
            btn.setText(value);
            btn.setBackground(value);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }
    }

}
