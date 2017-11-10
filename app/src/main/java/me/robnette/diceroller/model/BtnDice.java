package me.robnette.diceroller.model;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Robnette on 10/11/2017.
 */

public class BtnDice extends ButtonAbstract {

    public BtnDice(int min, int max, int value, View viewBtnLess, View viewBtnMore, TextView viewText) {
        super(min, max, value, viewBtnLess, viewBtnMore, viewText);
        init();
    }

    @Override
    public String getText() {
        return getValue() + "d";
    }
}
