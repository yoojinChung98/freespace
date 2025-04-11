package org.example.freespace.javastudy.enumstudy;

import lombok.Getter;

import java.util.Arrays;

public enum DrinkType {
    COFFEE(0.5, new CafeDrink[]{
            CafeDrink.AMERICANO, CafeDrink.LATTE
    } ),
    TEA(0.3, new CafeDrink[]{
            CafeDrink.CAMOMILE
    }),
    ADE(0.1, new CafeDrink[]{
            CafeDrink.ICETEA
    });

    @Getter
    private final double discount;
    @Getter
    private final CafeDrink[] containDrinks;

    DrinkType(double discount, CafeDrink[] containDrinks) {
        this.discount = discount;
        this.containDrinks = containDrinks;
    }

    public static DrinkType findDrinkType(CafeDrink drink) {
        return Arrays.stream(DrinkType.values())
                .filter(type -> hasDrink(type, drink))
                .findFirst()
                .orElse(null); // .orElse(CafeDrink.EMPTY)
    }

    public static boolean hasDrink(DrinkType type, CafeDrink drink) {
        return Arrays.stream(type.containDrinks)
                .anyMatch(containDrinks -> containDrinks == drink);
    }
}
