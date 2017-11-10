package me.robnette.diceroller.activity.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.robnette.diceroller.R;
import me.robnette.diceroller.model.BtnAdd;
import me.robnette.diceroller.model.BtnCustom;
import me.robnette.diceroller.model.BtnDice;
import me.robnette.diceroller.model.ButtonAbstract;
import me.robnette.diceroller.model.DiceEnum;
import me.robnette.diceroller.model.DiceModel;
import me.robnette.diceroller.service.RandomService;
import me.robnette.diceroller.util.Constant;

public class DiceFragment extends Fragment {

    private static DiceFragment instance;
    private Button btnDiceLess, btnDiceMore;
    private TextView textDice;
    private int nbDice = 1;
    private Button btnAddLess, btnAddMore;
    private TextView textAdd;
    private int addNum = 0;
    private Button btnCustomLess, btnCustomMore;
    private TextView textCustom;
    private int customNum = 50;

    private Map<Integer, DiceEnum> diceMap;

    public DiceFragment() {}

    public static DiceFragment newInstance(int page) {
        if(instance == null){
            Bundle args = new Bundle();
            args.putInt(Constant.ARG_TAB_PAGE, page);
            instance = new DiceFragment();
            instance.setArguments(args);
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        diceMap = new HashMap<>();
        diceMap.put(R.id.imageD4, DiceEnum.D4);
        diceMap.put(R.id.imageD6, DiceEnum.D6);
        diceMap.put(R.id.imageD8, DiceEnum.D8);
        diceMap.put(R.id.imageD10, DiceEnum.D10);
        diceMap.put(R.id.imageD12, DiceEnum.D12);
        diceMap.put(R.id.imageD20, DiceEnum.D20);
        diceMap.put(R.id.imageD100, DiceEnum.D100);
        diceMap.put(R.id.imageCustom, DiceEnum.CUSTOM);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_dice, container, false);

        btnDiceLess = view.findViewById(R.id.btnDiceLess);
        btnDiceMore = view.findViewById(R.id.btnDiceMore);
        textDice = view.findViewById(R.id.textDice);
        btnAddLess = view.findViewById(R.id.btnAddLess);
        btnAddMore = view.findViewById(R.id.btnAddMore);
        textAdd = view.findViewById(R.id.textAdd);
        btnCustomLess = view.findViewById(R.id.btnCustomLess);
        btnCustomMore = view.findViewById(R.id.btnCustomMore);
        textCustom = view.findViewById(R.id.textCustom);

        final BtnDice btnDice = new BtnDice(1,  10, 1, btnDiceLess, btnDiceMore, textDice);
        final BtnAdd btnAdd = new BtnAdd(-50,  50, 0, btnAddLess, btnAddMore, textAdd);
        final BtnCustom btnCustom = new BtnCustom(2,  200, 50, btnCustomLess, btnCustomMore, textCustom);

        for(Map.Entry<Integer, DiceEnum> entry : diceMap.entrySet()) {
            int id = entry.getKey();
            final DiceEnum diceEnum = entry.getValue();

            ImageView imageView = view.findViewById(id);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DiceModel diceModel = new DiceModel(diceEnum, btnCustom.getValue());
                    int total = 0;
                    int tmp;
                    StringBuffer totalString = null;
                    for(int i = 0; i < btnDice.getValue(); i++){
                        tmp = RandomService.getRandom(diceModel);
                        total += tmp;
                        if(totalString == null){
                            totalString = new StringBuffer();
                        }else{
                            totalString.append(",");
                        }
                        totalString.append(""+tmp);
                    }
                    diceModel.setView(view);
                    diceModel.setResult(total);
                    diceModel.setAddNum(btnAdd.getValue());
                    diceModel.setNbDice(btnDice.getValue());
                    diceModel.setTotalDetail(totalString.toString());

                    DiceModel diceModelHisto = (DiceModel)diceModel.clone();
                    HistoryFragment historyFragment = HistoryFragment.getInstance();
                    historyFragment.addData(diceModelHisto);

                    diceModel.updateFragment();
                    diceModel.setLastRool();

                }
            });
        }
        return view;
    }

}
