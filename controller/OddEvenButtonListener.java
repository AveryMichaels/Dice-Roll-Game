package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.AppWindow;

public class OddEvenButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case AppWindow.oddButtonAction:
                App.game.setOdd(true);
                break;
            case AppWindow.evenButtonAction:
                App.game.setOdd(false);
                break;
        }
    }
    
}
