package com.champlain.oop2.oop2assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * CompositeAnimal can be comprised of both CompositeAnimals and Enclosures
 * This is basically a list of lists.
 */
public class CompositeAnimal implements AnimalCollection {
    /**
     * The list that CompositeAnimal contains.
     * Either CompositeAnimal or Enclosures.
     */
    private final ArrayList<Object> aCollection;

    /**
     * The name of the CompositeAnimal group.
     */
    private String aName;

    /**
     * CompositeAnimal constructor
     */
    public CompositeAnimal(String pName) {
        aCollection = new ArrayList<>();
        aName = pName;
    }

    /**
     * Allows adding an Enclosure to aCollections.
     *
     * @param pEnclosure The object to add to the list. Must be Enclosure.
     */
    public void addEnclosure(Enclosure pEnclosure) {
        aCollection.add(pEnclosure);
    }

    /**
     * Allows removing an Enclosure from aCollections.
     *
     * @param pEnclosure The object to remove from the list. Must be Enclosure.
     */
    public void removeEnclosure(Enclosure pEnclosure) {
        aCollection.remove(pEnclosure);
    }

    /**
     * Allows adding a CompositeAnimal to aCollections.
     *
     * @param pCompositeAnimal The object to add to the list. Must be CompositeAnimal.
     */
    public void addCompositeAnimal(CompositeAnimal pCompositeAnimal) {
        aCollection.add(pCompositeAnimal);
    }

    /**
     * Allows removing a CompositeAnimal from aCollections.
     *
     * @param pCompositeAnimal The object to remove from the list. Must be CompositeAnimal.
     */
    public void removeCompositeAnimal(CompositeAnimal pCompositeAnimal) {
        aCollection.remove(pCompositeAnimal);
    }


    /**
     * Sets the name of the CompositeAnimal
     *
     * @param pName New name
     */
    @Override
    public void setName(String pName) {
        this.aName = pName;
    }

    /**
     * Gets the name of the CompositeAnimal
     *
     * @return the name of CompositeAnimal
     */
    @Override
    public String getName() {
        return this.aName;
    }

    /**
     * Accessor for aCollection
     *
     * @return the list of CompositeAnimal's contents
     */
    public List<Object> getList() {
        return new ArrayList<>(aCollection);
    }
}
