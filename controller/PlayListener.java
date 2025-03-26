package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.GameState;

public class PlayListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if((App.game.getAmountBetOddEven() == 0) && (App.game.getAmountBetRange() == 0)) {
            JOptionPane.showMessageDialog(App.win, "Please place your bet before playing.");
        } else {
            App.game.setState(GameState.OVER);
            App.win.updateWindow();
        }
    }
    
}
