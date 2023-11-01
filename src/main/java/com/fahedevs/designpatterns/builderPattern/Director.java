package com.fahedevs.designpatterns.builderPattern;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Director {
    private static final Set<String> allIngredients = new HashSet<>(
            List.of("ginger_roots", "scarab_beetles", "armadillo_bile", "hellebore", "moonstone",
                    "ashwinder_eggs", "rose_thorns", "peppermint")
    );

    private static Set<String> updateAvailableIngredients() {
        Set<String> availables = new HashSet<>();
        Iterator<String> iter = allIngredients.iterator();
        while (iter.hasNext()) {
            String ingredient = iter.next();
            if (Math.random() < 0.7) {
                availables.add(ingredient);
            }
        }
        return availables;
    }

    public static void makePotion(String clientRequest) {
        PotionMaker potionMaker = null;

        if (clientRequest.equalsIgnoreCase("Wit Sharpening Potion")) {
            log.info("\n\nDIRECTOR will try to get the Wit Sharpening Potion made\n");
            Set<String> availableIngredients = updateAvailableIngredients();
            potionMaker = new WitSharpeningPotionMaker();
            Set<String> neededIngredients = potionMaker.neededIngredients();
            log.info("NEEDED INGREDIENTS: {}", neededIngredients);
            log.info("Available ingredients: {}", availableIngredients);

            while (!availableIngredients.containsAll(neededIngredients)) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("Thread sleep interrupted", e);
                }
                availableIngredients = updateAvailableIngredients();
                log.info("Available ingredients: {}", availableIngredients);
            }
        } else if (clientRequest.equalsIgnoreCase("Draught of Peace Potion")) {
            log.info("\n\nDIRECTOR will try to get the Draught of Peace Potion made\n");
            Set<String> availableIngredients = updateAvailableIngredients();
            potionMaker = new DraughtOfPeacePotionMaker();
            Set<String> neededIngredients = potionMaker.neededIngredients();
            log.info("NEEDED INGREDIENTS: {}", neededIngredients);
            log.info("Available ingredients: {}", availableIngredients);

            while (!availableIngredients.containsAll(neededIngredients)) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("Thread sleep interrupted", e);
                }
                availableIngredients = updateAvailableIngredients();
                log.info("Available ingredients: {}", availableIngredients);
            }
        } else if (clientRequest.equalsIgnoreCase("Love Potion")) {
            log.info("\n\nDIRECTOR will try to get the Love Potion made\n");
            Set<String> availableIngredients = updateAvailableIngredients();
            potionMaker = new LovePotionMaker();
            Set<String> neededIngredients = potionMaker.neededIngredients();
            log.info("NEEDED INGREDIENTS: {}", neededIngredients);
            log.info("Available ingredients: {}", availableIngredients);

            while (!availableIngredients.containsAll(neededIngredients)) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    log.error("Thread sleep interrupted", e);
                }
                availableIngredients = updateAvailableIngredients();
                log.info("Available ingredients: {}", availableIngredients);
            }
        } else {
            log.error("Client request not understood. Exiting");
            System.exit(0);
        }

        log.info("\nDIRECTOR now has all the needed ingredients\n");

        try {
            potionMaker.makePotion();
            potionMaker.getResult();
        } catch (PotionMakingFeasibilityViolation e) {
            log.error(e.getMessage(), e);
        }
    }
}
