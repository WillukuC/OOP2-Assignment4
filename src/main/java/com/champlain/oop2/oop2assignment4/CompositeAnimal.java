package com.champlain.oop2.oop2assignment4;

import java.util.ArrayList;
import java.util.List;

public class CompositeAnimal implements AnimalCollection {
    private final List<AnimalCollection> aCollections = new ArrayList<AnimalCollection>();

    public void addCollection(AnimalCollection pCollection) {
        this.aCollections.add(pCollection);
    }

    public void removeCollection(AnimalCollection pCollection) {
        this.aCollections.remove(pCollection);
    }

    @Override
    public String showAllAnimals(){
        StringBuilder allAnimals = new StringBuilder();
        for (AnimalCollection currentCollection : aCollections) {
            allAnimals.append(currentCollection.toString());
        }
        return allAnimals.toString();
    }
}
