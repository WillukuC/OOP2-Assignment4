package com.champlain.oop2.oop2assignment4;

public class Animal {
<<<<<<< Updated upstream

    private String aName;

    private String aSpecies;

    private String aEnclosure;

    private Double aWeight;

    private Double aAge;

    public String getName() {
        return aName;
    }

    public void setName(String aName) {
        this.aName = aName;
    }

    public Double getWeight() {
        return aWeight;
    }

    public void setWeight(Double aWeight) {
        this.aWeight = aWeight;
    }

    public Double getAge() {
        return aAge;
    }

    public void setAge(Double aAge) {
        this.aAge = aAge;
=======
    private String name;
    private String species;
    private int age;
    private String enclosure;
    private int weight;

    public String getName(){
        return name;
    }
    public String getSpecies(){
        return species;
    }
    public int getAge(){
        return age;
    }
    public String getEnclosure(){
        return enclosure;
    }
    public void setName(String pName){
        this.name = pName;
    }
    public void setSpecies(String pSpecies){
        this.species = pSpecies;
    }
    public void setAge(int pAge){
        this.age = pAge;
    }
    public void setEnclosure(String pEnclosure){
        this.enclosure = pEnclosure;
>>>>>>> Stashed changes
    }
}
