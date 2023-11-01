package com.fahedevs.designpatterns.builderPattern;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class DraughtOfPeacePotionMaker extends PotionMaker{
    public Set<String> neededIngredients() {
        return new HashSet<String>(List.of("moonstone", "hellebore"));
    }
    protected boolean prepareAndAddMoonstone() throws PotionMakingFeasibilityViolation {
        moonstone = new Ingredient( "moonstone", "to be powdered");
        log.info( "Moonstone powdered and added to the potion");
        log.info( "Stirred potion three times counterclockwise");
        log.info( "Allowed the potion to simmer for exactly " + "seven minutes");
        return true;
    }
    protected boolean prepareAndAddHellebore()
            throws PotionMakingFeasibilityViolation {
        if ( moonstone == null ) {throw new PotionMakingFeasibilityViolation("\nMoonstone must be powdered and added " + "before hellebore can be added to the potion.\n" );
        }
        hellebore = new Ingredient( "hellebore", "add as a syrup");
        log.info("Added two drops of the syrup of hellebore to the potion");
        return true;
    }
    public void makePotion() throws PotionMakingFeasibilityViolation{
        prepareAndAddMoonstone();
        prepareAndAddHellebore();
    }
    public Potion getResult() {
        if ( moonstone != null & hellebore != null ) {
        potionMade = new Potion(
                "Draught Of Peace",
                new ArrayList<Ingredient>( List.of( moonstone, hellebore ))
        );
            log.info("\nDraught of Peace Potion made by " + "DraughtOfPeacePotionMaker.java\n" );
        return potionMade;
    } else {
            log.info("DraughtOfPeacePotionMaker unable to make the potion" );
        return null;
    }
    }
}
