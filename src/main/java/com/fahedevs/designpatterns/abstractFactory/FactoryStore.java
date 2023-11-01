package com.fahedevs.designpatterns.abstractFactory;

import java.util.ArrayList;
import java.util.List;

public class FactoryStore {
    private static FactoryStore theStore;
    private String forWhichSchool;
    private static final int N = 2;
    private int broomsticksDeliveredFromNewStock;
    private int magicWandsDeliveredFromNewStock;
    private int owlsDeliveredFromNewStock;
    private List<Broomstick> broomsticksInStock = new ArrayList<Broomstick>();
    private List<MagicWand> magicWandsInStock = new ArrayList<MagicWand>();
    private List<Owl> owlsInStock = new ArrayList<Owl>();
    private FactoryStore( String forWhichSchool ) {
        this.forWhichSchool = forWhichSchool;
        broomsticksDeliveredFromNewStock =
                magicWandsDeliveredFromNewStock =
                        owlsDeliveredFromNewStock = 0;
        for ( int i = 0; i < N; i++ ) {
            broomsticksInStock.add( new Broomstick( forWhichSchool ));
            magicWandsInStock.add( new MagicWand( forWhichSchool ));
            owlsInStock.add( new Owl( forWhichSchool ));
        }
    }
    public static FactoryStore makeFactoryStore(String forWhichSchool) {
        if (theStore == null) {
            theStore = new FactoryStore(forWhichSchool);
        }
        return theStore;
    }
    public int batchSize() { return N; }
    public String forWhichSchool() { return forWhichSchool; }
    public void acquireMoreBroomsticksFromFactory(
            List<Broomstick> freshStock) {
        broomsticksInStock = freshStock;
    }
    public void initializeBroomstickStock() {
        broomsticksDeliveredFromNewStock = 0;
    }
    public void acquireMoreMagicWandsFromFactory(
            List<MagicWand> freshStock) {
        magicWandsInStock = freshStock;
    }
    public void initializeMagicWandStock() {
        magicWandsDeliveredFromNewStock = 0;
    }
    public void acquireMoreOwlsFromEmporium(List<Owl> freshStock) {
        owlsInStock = freshStock;
    }
    public void initializeOwlStock() {
        owlsDeliveredFromNewStock = 0;
    }
    public boolean checkBroomstickStockIsEmpty() {
        return broomsticksDeliveredFromNewStock == N;
    }
    public boolean checkMagicWandStockIsEmpty() {
        return magicWandsDeliveredFromNewStock == N;
    }
    public boolean checkOwlStockIsEmpty() {
        return owlsDeliveredFromNewStock == N;
    }
    public Broomstick deliverOneBroomstickToClient() {
        return broomsticksInStock.get(broomsticksDeliveredFromNewStock++);
    }
    public MagicWand deliverOneMagicWandToClient() {
        return magicWandsInStock.get(magicWandsDeliveredFromNewStock++);
    }
    public Owl deliverOneOwlToClient() {
        return owlsInStock.get(owlsDeliveredFromNewStock++);
    }
}
