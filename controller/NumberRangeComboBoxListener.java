package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class NumberRangeComboBoxListener implements ItemListener{

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
            String amount = (String) e.getItem();

            if(amount.equals("Choose Amount")) {
                App.game.setAmountBetRange(0);
            } else if(amount.equals("$10")) {
                App.game.setAmountBetRange(10);
            } else if(amount.equals("$20")) {
                App.game.setAmountBetRange(20);
            } else if(amount.equals("$30")) {
                App.game.setAmountBetRange(30);
            }
        }
    }
    
}
