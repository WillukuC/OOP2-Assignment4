package com.champlain.oop2.oop2assignment4;

import java.util.List;

public class ZooSingleton implements AnimalCollection {
    private static ZooSingleton single_instance = null;

    private String aName;

    private CompositeAnimal aZoo = null;

    private ZooSingleton() {
        // Lions
        aZoo = new CompositeAnimal("Zoo");

        Enclosure lions = new Enclosure("Lions");
        lions.addAnimal(new Lion("Simba"));
        lions.addAnimal(new Lion("Mufasa"));
        lions.addAnimal(new Lion("Nala"));

        // Tigers
        Enclosure tigerHabitat = new Enclosure("Tiger Habitat");
        tigerHabitat.addAnimal(new Tiger("Rajah"));
        tigerHabitat.addAnimal(new Tiger("Shere Khan"));

        Enclosure tigerCubs = new Enclosure("Tiger Cubs");
        tigerCubs.addAnimal(new Tiger("Tala (Mother)"));
        tigerCubs.addAnimal(new Tiger("Ravi"));
        tigerCubs.addAnimal(new Tiger("Kali"));
        tigerCubs.addAnimal(new Tiger("Indra"));

        CompositeAnimal tigers = new CompositeAnimal("Tigers");
        tigers.addEnclosure(tigerHabitat);
        tigers.addEnclosure(tigerCubs);

        // Cougars
        Enclosure cougarMedical = new Enclosure("Cougar Medical Care");
        cougarMedical.addAnimal(new Cougar("Sierra"));

        Enclosure cougarHabitat = new Enclosure("Cougar Habitat");
        cougarHabitat.addAnimal(new Cougar("Rocky"));
        cougarHabitat.addAnimal(new Cougar("Luna"));
        cougarHabitat.addAnimal(new Cougar("Lenny"));

        CompositeAnimal cougars = new CompositeAnimal("Cougars");
        cougars.addEnclosure(cougarHabitat);
        cougars.addEnclosure(cougarMedical);

        // Zoo
        aZoo.addEnclosure(lions);
        aZoo.addCompositeAnimal(tigers);
        aZoo.addCompositeAnimal(cougars);
    }

    public static synchronized ZooSingleton getInstance() {
        if (single_instance == null) {
            single_instance = new ZooSingleton();
        }
        return single_instance;
    }


    @Override
    public void setName(String pName) {
        aName = pName;
    }

    @Override
    public String getName() {
        return aName;
    }

    @Override
    public String showAllAnimals() {
        return null;
    }

    public List<Object> getObjectList() {
        return aZoo.getList();
    }
}
