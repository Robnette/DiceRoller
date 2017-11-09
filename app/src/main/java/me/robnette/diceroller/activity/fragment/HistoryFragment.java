package me.robnette.diceroller.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import me.robnette.diceroller.R;
import me.robnette.diceroller.activity.adapter.HistoryArrayAdapter;
import me.robnette.diceroller.model.DiceEnum;
import me.robnette.diceroller.model.DiceModel;

/**
 * Created by Robnette on 06/11/2017.
 */

public class HistoryFragment extends Fragment {
    private static HistoryFragment instance;
    private HistoryArrayAdapter adapter;
    private View view;
    private boolean empty = true;

    public HistoryFragment() {}

    public static HistoryFragment getInstance() {
        if(instance == null){
            instance = new HistoryFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_history, container, false);

        final ListView listview = (ListView) view.findViewById(R.id.resultListview);

        adapter = new HistoryArrayAdapter(view.getContext(), android.R.layout.simple_list_item_1);
        listview.setAdapter(adapter);

        List<DiceModel> list = new ArrayList<>();
        list.add(new DiceModel(DiceEnum.D4, null));
        adapter.setData(list);

        return view;
    }

    public void addData(DiceModel diceModel){
        if(empty){
            TextView emptyTextView = view.findViewById(R.id.emptyText);
            emptyTextView.setVisibility(View.INVISIBLE);

            ListView resultList = view.findViewById(R.id.resultListview);
            resultList.setVisibility(View.VISIBLE);

            adapter.clear();
            empty = false;
        }
        diceModel.setView(view);
        diceModel.updateFragment();
        adapter.addData(diceModel);
    }
}
