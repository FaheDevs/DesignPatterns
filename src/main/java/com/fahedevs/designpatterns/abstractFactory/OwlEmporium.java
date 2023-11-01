package com.fahedevs.designpatterns.abstractFactory;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class OwlEmporium extends Factory{
    public OwlEmporium( String schoolName ) { super(schoolName); }
    Owl deliverItem() {
        return deliverOwl();
    }
    private Owl deliverOwl() {
        if ( store.checkOwlStockIsEmpty() ) replenishOwlStock();
        return store.deliverOneOwlToClient();
    }
    private void replenishOwlStock() {
        log.info("Replenishing stock with {} magic wands", store.batchSize());
        var freshStock = IntStream.range(0, store.batchSize())
                .mapToObj(i -> new Owl(store.forWhichSchool()))
                .collect(Collectors.toList());
        store.acquireMoreOwlsFromEmporium(freshStock);
        store.initializeOwlStock();
    }
}
