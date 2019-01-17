package Views;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JComponent {
    private JButton checkSolutionBtn = new JButton("Check solution");
    private JButton helpBtn = new JButton("Help");
    private JButton saveBtn = new JButton("Save");
    private JButton loadBtn = new JButton("Load");
    private JButton undoMoveBtn = new JButton("Undo");
    private JButton redoMoveBtn = new JButton("Redo");

    public MenuView(GameGUI gui, BoardView boardView) {
        setLayout(new GridLayout(2,4, 1 ,0));
        add(checkSolutionBtn);
        add(helpBtn);
        add(saveBtn);
        add(loadBtn);
        add(loadBtn);
        add(undoMoveBtn);
        add(redoMoveBtn);

        checkSolutionBtn.addActionListener(evt -> {
            if (boardView.checkSolution()) {
                JOptionPane.showMessageDialog(gui, "Wygrales!");
                checkSolutionBtn.setEnabled(false);
                helpBtn.setEnabled(false);
                saveBtn.setEnabled(false);
                loadBtn.setEnabled(false);
                undoMoveBtn.setEnabled(false);
                redoMoveBtn.setEnabled(false);
                boardView.removeListenerFromBoardButtons();
            } else {
                JOptionPane.showMessageDialog(gui, "Zle rozwiazanie");
            }
        });

        helpBtn.addActionListener(evt -> {
            JOptionPane.showMessageDialog(gui, "Przedstawiony na rysunku kwadrat podzielony był wzdłuż oznaczonych linii na n części różnej wielkości,\n a w każdym małym kwadracie znajdowała się liczba oznaczająca, z ilu kwadratów składa się część, do której ten kwadrat należy.\nInaczej mówiąc: kwadratów z daną liczbą x było x i tworzyły one jedną spójną część (jeden wielobok). Granice podziału i większość liczb usunięto.\nZadanie polega na odtworzeniu tego podziału na podstawie dwunastu pozostawionych liczb.");
        });

        saveBtn.addActionListener(evt -> {
            gui.saveGame();
        });

        loadBtn.addActionListener(evt -> {
            gui.loadGame();
        });

        undoMoveBtn.addActionListener(evt -> {
            boardView.undoMove();
        });

        redoMoveBtn.addActionListener(evt -> {
            boardView.redoMove();
        });
    }
}
