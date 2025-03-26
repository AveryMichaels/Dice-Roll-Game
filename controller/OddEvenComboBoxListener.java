package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class OddEvenComboBoxListener implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            String amount = (String) e.getItem();

            if(amount.equals("Choose Amount")) {
                App.game.setAmountBetOddEven(0);
            } else if(amount.equals("$10")) {
                App.game.setAmountBetOddEven(10);
            } else if(amount.equals("$20")) {
                App.game.setAmountBetOddEven(20);
            } else if(amount.equals("$30")) {
                App.game.setAmountBetOddEven(30);
            }
        }
    }
    
}
