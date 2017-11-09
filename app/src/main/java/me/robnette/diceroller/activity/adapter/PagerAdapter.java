package me.robnette.diceroller.activity.adapter;



import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.robnette.diceroller.activity.fragment.DiceFragment;
import me.robnette.diceroller.activity.fragment.HistoryFragment;

/**
 * Created by Robnette on 06/11/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[] { "Rob's Dice", "Historique Tab" };
    private Context context;

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        if(position == 0){
            fragment = DiceFragment.newInstance(position + 1);
        }else{
            fragment = HistoryFragment.getInstance();
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
