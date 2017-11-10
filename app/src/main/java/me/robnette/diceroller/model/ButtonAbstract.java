package me.robnette.diceroller.model;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Robnette on 10/11/2017.
 */

public abstract class ButtonAbstract {

    private int min, max, value;
    private View viewBtnLess, viewBtnMore;
    private TextView viewText;

    protected ButtonAbstract(int min, int max, int value, View viewBtnLess, View viewBtnMore, TextView viewText) {
        this.min = min;
        this.max = max;
        this.value = value;
        this.viewBtnLess = viewBtnLess;
        this.viewBtnMore = viewBtnMore;
        this.viewText = viewText;
    }

    public void add(){
        value++;
    }

    public void remove(){
        value--;
    }

    public void setValueToMin(){
        value = min;
    }

    public void setValueToMax(){
        value = max;
    }

    public int getValue() {
        return value;
    }

    public View getViewBtnLess() {
        return viewBtnLess;
    }

    public View getViewBtnMore() {
        return viewBtnMore;
    }

    public View getViewText() {
        return viewText;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    protected void init(){
        viewBtnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(value > min){
                value--;
                setText();
            }
            }
        });
        viewBtnLess.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                value = min;
                setText();
                return true;
            }
        });

        viewBtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value < max){
                    value++;
                    setText();
                }
            }
        });
        viewBtnMore.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                value = max;
                setText();
                return true;
            }
        });
    }

    private void setText(){
        viewText.setText(getText());
    }

    public abstract String getText();
}
