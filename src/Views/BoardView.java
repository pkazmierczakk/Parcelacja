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
    private BoardButton[][] boardButtons;
    private BoardController boardController;
    BoardView(BoardController boardController) {
        this.boardController = boardController;
        setLayout(new GridLayout(9,9, 2,2));
        setBoardController(boardController);
    }

    public void generateView() {
        removeAll();
        FriendlyField[][] board = boardController.getBoard();
        boardButtons = new BoardButton[board.length][board.length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                FriendlyField f = board[y][x];
                BoardButton boardBtn = new BoardButton(f.getVal(), f.getCoord());
                if (!f.isEditable()) {
                    boardBtn.setEnabled(false);
                } else {
                    boardBtn.setMouseListener(new ClickBoardButtonListener());
                }
                boardBtn.decorateButton();
                boardButtons[y][x] = boardBtn;
                boardBtn.setBackground(f.getVal());
                add(boardBtn);
            }
        }
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
        BoardButton bb = boardButtons[move.getCoord().getCoordY()][move.getCoord().getCoordX()];
        bb.setText(move.getCurrentValue());
    }
    public boolean checkSolution() {
        return boardController.checkSolution();
    }

    public void removeListenerFromBoardButtons() {
        for (int i = 0; i < boardButtons.length; i++) {
            for (int j = 0; j < boardButtons[i].length; j++) {
                boardButtons[i][j].removeMouseListener();
            }
        }
    }

    public class ClickBoardButtonListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent evt) {
            BoardButton btn = (BoardButton)evt.getSource();
            if (evt.getButton() == MouseEvent.BUTTON1) {
                btn.setText(boardController.addToFieldAndReturn(btn.getCoords(), 2));
//                btn.addToValue(2);
             } else if (evt.getButton() == MouseEvent.BUTTON3) {
                btn.setText(boardController.addToFieldAndReturn(btn.getCoords(), -1));
            }
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
