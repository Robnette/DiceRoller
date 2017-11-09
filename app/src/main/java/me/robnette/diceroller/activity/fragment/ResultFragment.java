package me.robnette.diceroller.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.robnette.diceroller.R;
import me.robnette.diceroller.model.DiceModel;
import me.robnette.diceroller.util.Constant;
import me.robnette.diceroller.util.Time;

public class ResultFragment extends Fragment {

    private TextView resultRoll, resultRollTime, resultRollType, resultDetail, lastRoll;
    private static ResultFragment instance;

    public ResultFragment() {
        // Required empty public constructor
    }

    public static ResultFragment newInstance() {
        if(instance == null){
//            Bundle args = new Bundle();
//            args.putInt(Constant.ARG_TAB_PAGE, page);
            instance = new ResultFragment();
//            instance.setArguments(args);
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mPage = getArguments().getInt(Constant.ARG_TAB_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);




        Log.d("test", "???????????????????????????????????????????????????? onCreateView");

        return view;
    }



}
