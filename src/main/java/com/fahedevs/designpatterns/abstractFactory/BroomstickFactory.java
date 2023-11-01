package com.fahedevs.designpatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Slf4j
public class BroomstickFactory extends Factory {
    public BroomstickFactory( String schoolName ) { super(schoolName); }
    public Broomstick deliverItem() {
        return deliverBroomstick();
    }
    private Broomstick deliverBroomstick() {
        log.info("delivering {}", this.getClass());
        if ( store.checkBroomstickStockIsEmpty() )
            replenishBroomstickStock();
        return store.deliverOneBroomstickToClient();
    }
    private void replenishBroomstickStock() {
        log.info("Replenishing stock with {} magic wands", store.batchSize());
        var freshStock = IntStream.range(0, store.batchSize())
                .mapToObj(i -> new Broomstick(store.forWhichSchool()))
                .collect(Collectors.toList());
        store.acquireMoreBroomsticksFromFactory(freshStock);
        store.initializeBroomstickStock();
    }
}
