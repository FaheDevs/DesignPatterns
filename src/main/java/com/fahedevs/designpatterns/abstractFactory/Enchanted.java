package com.fahedevs.designpatterns.abstractFactory;

import lombok.Getter;

public class Enchanted {
    @Getter
    public int idNum;
    public String schoolID;
    public String itemType;
    public Enchanted( String forWhichSchool, String itemType ) {
        schoolID = forWhichSchool;
        this.itemType = itemType;
    }

    public void print() { System.out.println( idNum + " " + schoolID ); }
    public String toString() {
        return schoolID + "_" + itemType + "_" + idNum;
    }
}
