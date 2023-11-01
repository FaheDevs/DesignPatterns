package com.fahedevs.designpatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class MagicWandFactory extends Factory{
    public MagicWandFactory( String schoolName ) { super(schoolName); }
    MagicWand deliverItem() {
        return deliverMagicWand();
    }
    private MagicWand deliverMagicWand() {
        if ( store.checkMagicWandStockIsEmpty() )
            replenishMagicWandStock();
        return store.deliverOneMagicWandToClient();
    }
    private void replenishMagicWandStock() {
       log.info("Replenishing stock with {} magic wands", store.batchSize());
        var freshStock = IntStream.range(0, store.batchSize())
                .mapToObj(i -> new MagicWand(store.forWhichSchool()))
                .collect(Collectors.toList());
        store.acquireMoreMagicWandsFromFactory(freshStock);
        store.initializeMagicWandStock();
    }
}
