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
    private final List<Object> aCollection;

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
     * Allows adding CompositeAnimal or Enclosure to aCollections.
     *
     * @param pObject The object to add to the list. Must be either CompositeAnimal or Enclosure.
     * @throws IllegalArgumentException if pObject is neither CompositeAnimal or Enclosure
     */
    public void addObject(Object pObject) {
        if (pObject instanceof CompositeAnimal || pObject instanceof Enclosure) {
            aCollection.add(pObject);
        } else {
            throw new IllegalArgumentException("Object not supported.");
        }
    }

    /**
     * Allows removing an object from aCollections.
     *
     * @param pObject The object to remove from the list.
     */
    public void removeObject(Object pObject) {
        aCollection.remove(pObject);
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
     * Shows all the Collections in the current CompositeAnimal
     *
     * @return a String of all the Collections together
     */
    @Override
    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (Object currentCollection : aCollection) {
            allAnimals.append(currentCollection.toString());
            if (!(allAnimals.indexOf(String.valueOf(currentCollection)) == aCollection.size() - 1)) {
                allAnimals.append(", ");
            }
        }
        return allAnimals.toString();
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
