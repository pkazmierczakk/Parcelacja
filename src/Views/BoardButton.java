package Views;

import Utils.Coordinate;
import Utils.FriendlyField;

import javax.swing.*;
import java.awt.*;

public class BoardButton extends JButton {
    private final static String[] COLORS = new String[] {"#fed766", "#98d2eb", "#e1f2fe", "#b2b1cf", "#8da7be", "#554640", "#a9b18f", "#5b9279", "#8fcb9b", "#d8cfaf", "#e6b89c", "#ed9390", "#4effef", "#73a6ad", "#9b97b2", "#f6caca", "#888888"};
    private FriendlyField friendlyField;
    private Coordinate coord;
    private boolean isEnabled = true;

    BoardButton(int value, Coordinate coord) {
        super();
        setText(value);
        this.coord = coord;
    }

    public void setText(int val) {
        setBackground(val);
        String text = "";
        if (val != 0) {
            text = Integer.toString(val);
        }
        super.setText(text);
    }


//    public void addToValue(int val) {
//        System.out.println(currentValue);
//        currentValue += val;
//        if (currentValue > 15) {
//            currentValue %= 16;
//        } else if (currentValue < 0){
//            currentValue += 16;
//        }
//        setText(currentValue);
//    }

    @Override
    public void setEnabled(boolean b) {
        isEnabled = false;
        this.setBorder(BorderFactory.createLineBorder(Color.decode("#662c91"), 3));
    }

    public Coordinate getCoords() {
        return coord;
    }

    public void decorateButton() {
        this.setForeground(Color.decode("#000000"));
        if (isEnabled)
            this.setBorder(BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 3));
        this.setFont(new Font("Tahoma", Font.BOLD , 15));
    }

    public void setBackground(int index) {
        super.setBackground(Color.decode(COLORS[index]));
    }
}
