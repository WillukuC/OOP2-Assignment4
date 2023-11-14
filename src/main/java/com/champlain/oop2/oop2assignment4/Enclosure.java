package com.champlain.oop2.oop2assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * The Enclosure class only contains a list of Animals. Has methods to add and remove animals.
 */
public class Enclosure<Animal> extends ArrayList<Animal> implements AnimalCollection{
    /**
     * Name of the Enclosure
     */
    private String aName;

    /**
     * Enclosure Constructor
     * @param pName names the Enclosure upon initialization
     */
    public Enclosure(String pName) {
        aName = pName;
    }

    /**
     * Adds specified Animal to the Enclosure
     * @param pAnimal Animal to add
     */
    public void addAnimal(Animal pAnimal){
        this.add(pAnimal);
    }

    /**
     * Returns the name of the Enclosure
     * @return Enclosure name
     */
    @Override
    public String getName(){
        return this.aName;
    }

    /**
     * Changes the name of the Enclosure
     * @param pName New name for the Enclosure
     */
    @Override
    public void setName(String pName){
        this.aName = pName;
    }
}
