package com.champlain.oop2.oop2assignment4;

import java.util.ArrayList;
import java.util.List;

/**
 * The Enclosure class only contains a list of Animals. Has methods to add and remove animals.
 */
public class Enclosure implements AnimalCollection{
    /**
     * List of the Animals in the Enclosure
     */
    private final List aAnimals;

    /**
     * Name of the Enclosure
     */
    private String aName;

    /**
     * Enclosure Constructor
     * @param pName names the Enclosure upon initialization
     */
    public Enclosure(String pName) {
        aAnimals = new ArrayList<>();
        aName = pName;
    }

    /**
     * Adds specified Animal to the Enclosure
     * @param pAnimal Animal to add
     */
    public void addAnimal(Animal pAnimal){
        this.aAnimals.add(pAnimal);
    }

    /**
     * Removes specified Animal from the Enclosure
     * @param pAnimal Animal to remove
     */
    public void removeAnimal(Animal pAnimal){
        this.aAnimals.remove(pAnimal);
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

    /**
     * Shows all the animals in the Enclosure
     * @return String
     */
    @Override
    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (Object currentAnimal : aAnimals){
            allAnimals.append(currentAnimal.toString());
            if (!(allAnimals.indexOf(String.valueOf(currentAnimal)) == aAnimals.size() - 1)) {
                allAnimals.append(", ");
            }
        }
        return allAnimals.toString();
    }

    public List<Animal> getList() {
        return aAnimals;
    }
}
