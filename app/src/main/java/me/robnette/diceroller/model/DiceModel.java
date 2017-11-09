package me.robnette.diceroller.model;

import android.view.View;
import android.widget.TextView;

import me.robnette.diceroller.R;
import me.robnette.diceroller.util.Time;

/**
 * Created by Robnette on 06/11/2017.
 */

public class DiceModel implements Cloneable {
    private DiceEnum type;
    private int dx;
    private int result, addNum, nbDice;
    private String totalDetail, time;
    private View view;

    public DiceModel(DiceEnum type, Integer dx) {
        this.type = type;
        switch (type){
            case D4: this.dx = 4; break;
            case D6: this.dx = 6; break;
            case D8: this.dx = 8; break;
            case D10: this.dx = 10; break;
            case D12: this.dx = 12; break;
            case D20: this.dx = 20; break;
            case D100: this.dx = 100; break;
            case CUSTOM: this.dx = dx; break;
            default:
                throw new RuntimeException("Dice type unknown");
        }
        time = Time.getTimeDisplay();
    }

    public int getDx() {
        return dx;
    }

    private String getTypeDisplay(){
        return  nbDice + "d" + dx + (addNum >= 0 ? "+" : "-") + addNum;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setAddNum(int addNum) {
        this.addNum = addNum;
    }

    public void setNbDice(int nbDice) {
        this.nbDice = nbDice;
    }

    public void setTotalDetail(String totalDetail) {
        this.totalDetail = totalDetail;
    }

    private String getResult(){
        return "" + (result + addNum);
    }

    private String getTime() {
        return time;
    }

    private String getResultDetail(){
        return totalDetail + (addNum >= 0 ? "+" : "-") + addNum;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void updateFragment(){
        TextView resultRoll, resultRollTime, resultRollType, resultDetail;

        resultRoll = view.findViewById(R.id.rollResult);
        resultRollTime = view.findViewById(R.id.rollResultTime);
        resultRollType = view.findViewById(R.id.rollResultType);
        resultDetail = view.findViewById(R.id.resultDetail);

        resultRoll.setText(getResult());
        resultRollType.setText(getTypeDisplay());
        resultRollTime.setText(getTime());
        resultDetail.setText(getResultDetail());
    }

    public void setLastRool(){
        TextView lastRoll = view.findViewById(R.id.textLastRoll);
        lastRoll.setVisibility(View.VISIBLE);
    }

    public Object clone() {
        try {
            DiceModel diceModel = (DiceModel)super.clone();
            diceModel.setView(null);
            return diceModel;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
