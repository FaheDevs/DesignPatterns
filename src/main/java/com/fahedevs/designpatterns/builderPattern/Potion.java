package com.fahedevs.designpatterns.builderPattern;

import java.util.List;

public class Potion {
    String name;
    List<Ingredient> ingredients;
    public Potion( String name, List<Ingredient> ingredients ) {
        this.name = name;
        this.ingredients = ingredients;
    }
}
