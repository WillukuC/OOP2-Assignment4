package com.champlain.oop2.oop2assignment4;

import java.util.ArrayList;
import java.util.List;

public class Enclosure implements AnimalCollection{
    private String aCollections;
    private final List<Animal> aAnimals = new ArrayList<>();
    public void addAnimal(Animal pAnimal){
        this.aAnimals.add(pAnimal);
    }
    public String aName;
    @Override
    public String getName(){
        return this.aName;
    }

    @Override
    public String showAllAnimals() {
        StringBuilder allAnimals = new StringBuilder();
        for (Animal currentAnimal : aAnimals){
            allAnimals.append(currentAnimal.toString());
        }
        return allAnimals.toString();
    }

    @Override
    public void setName(String pName){
        this.aName = pName;
    }

    public String getCollection(){
        return aCollections;
    }
    public void setCollection(String aCollection){
        this.aCollections = aCollections;
    }
}
