package com.champlain.oop2.oop2assignment4;

import java.util.List;

public class ZooSingleton implements AnimalCollection {
    private static ZooSingleton single_instance = null;

    private String aName;

    private CompositeAnimal aZoo;

    private ZooSingleton() {
        // Lions
        aZoo = new CompositeAnimal("Zoo");

        Enclosure<Animal> lions = new Enclosure<>("Lions");
        lions.add(new Lion("Simba"));
        lions.add(new Lion("Mufasa"));
        lions.add(new Lion("Nala"));

        // Tigers
        Enclosure<Animal> tigerHabitat = new Enclosure<>("Tiger Habitat");
        tigerHabitat.add(new Tiger("Rajah"));
        tigerHabitat.add(new Tiger("Shere Khan"));

        Enclosure<Animal> tigerCubs = new Enclosure<>("Tiger Cubs");
        tigerCubs.add(new Tiger("Tala (Mother)"));
        tigerCubs.add(new Tiger("Ravi"));
        tigerCubs.add(new Tiger("Kali"));
        tigerCubs.add(new Tiger("Indra"));

        CompositeAnimal tigers = new CompositeAnimal("Tigers");
        tigers.addEnclosure(tigerHabitat);
        tigers.addEnclosure(tigerCubs);

        // Cougars
        Enclosure<Animal> cougarMedical = new Enclosure<>("Cougar Medical Care");
        cougarMedical.add(new Cougar("Sierra"));

        Enclosure<Animal> cougarHabitat = new Enclosure<>("Cougar Habitat");
        cougarHabitat.add(new Cougar("Rocky"));
        cougarHabitat.add(new Cougar("Luna"));
        cougarHabitat.add(new Cougar("Lenny"));

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

    public CompositeAnimal getZoo() {
        return aZoo;
    }
}
