package Views;

import Controller.BoardController;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GameGUI extends JFrame {
    private BoardView boardView;
    private MenuView menuView;
    private BoardController boardController;
    private JFileChooser fileChooser = new JFileChooser("./saves");

    public GameGUI() {
        boardController = new BoardController();
        boardView = new BoardView(boardController);
        menuView = new MenuView(this, boardView);
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new BorderLayout(10, 10));
        boardPanel.add(boardView, BorderLayout.CENTER);
        boardPanel.add(menuView, BorderLayout.NORTH);

        add(boardPanel);

        boardView.setVisible(true);
        setVisible(true);
        setSize(600, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void saveGame() {
        File saveFile;
        int returnValue = fileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            saveFile = fileChooser.getSelectedFile();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(boardController);
                System.out.println("Zapisano");



            } catch (FileNotFoundException e) {
                System.err.println("SAVE: FILE NOT FOUND");
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("SAVE: INPUT OUTPUT EXCEPTION");
                e.printStackTrace();
            }
        }
    }

    public void loadGame()
    {
        File loadFile;
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            loadFile = fileChooser.getSelectedFile();
            try
            {
                FileInputStream fileInputStream = new FileInputStream(loadFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                boardController = (BoardController) objectInputStream.readObject();
                boardView.setBoardController(boardController);

                System.out.println("wczytano");

            }
            catch (FileNotFoundException fnfe)
            {
                System.err.println("LOAD: FILE NOT FOUND");
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
                System.err.println("LOAD: INPUT OUTPUT EXCEPTION");
            }
            catch (ClassNotFoundException cnfe)
            {
                System.err.println("LOAD: WRONG FILE");
            }
        }
    }
}
