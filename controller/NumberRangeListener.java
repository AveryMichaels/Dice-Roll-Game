package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppWindow;

public class NumberRangeListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //set guess to corresponding button
        String action = e.getActionCommand();
        switch(action) {
            case AppWindow.oneTwoButtonAction:
                App.game.setRangeGuess("1-2");
                break;
            case AppWindow.threeFourButtonAction:
                App.game.setRangeGuess("3-4");
                break;
            case AppWindow.fiveSixButtonAction:
                App.game.setRangeGuess("5-6");
                break;
        }
    }
    
}
