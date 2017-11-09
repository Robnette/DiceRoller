package me.robnette.diceroller.service;

import java.util.Random;

import me.robnette.diceroller.model.DiceModel;

/**
 * Created by Robnette on 07/11/2017.
 */

public class RandomService {
    private static final RandomService ourInstance = new RandomService();
    private Random randomGenerator = new Random();

    public static int getRandom(DiceModel model){
        return 1 + ourInstance.randomGenerator.nextInt(model.getDx());
    }
}
