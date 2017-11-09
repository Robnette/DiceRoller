package me.robnette.diceroller.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

import me.robnette.diceroller.R;
import me.robnette.diceroller.model.DiceModel;

/**
 * Created by Robnette on 08/11/2017.
 */
public class HistoryArrayAdapter extends ArrayAdapter<DiceModel> {
    private final LayoutInflater mInflater;

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    public HistoryArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    public void setData(List<DiceModel> data) {
        clear();
        if (data != null) {
            for (DiceModel appEntry : data) {
                add(appEntry);
            }
        }
    }

    public void addData(DiceModel diceModel){

        insert(diceModel, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.fragment_result, parent, false);
        } else {
            view = convertView;
        }

        DiceModel diceModel = getItem(position);
        diceModel.setView(view);
        diceModel.updateFragment();

        return view;
    }

}
