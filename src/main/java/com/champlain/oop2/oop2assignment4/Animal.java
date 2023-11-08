package com.champlain.oop2.oop2assignment4;

public class Animal {

    private String aName;

    private String aSpecies;

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

    public void setWeight(Double pWeight) {
        if(pWeight < 0) {
            throw new IllegalArgumentException("The weight can't be smaller than 0");
        } if(pWeight > 1000) {
            throw new IllegalArgumentException("The weight can't be greater than 1000");
        } else {
            this.aWeight = pWeight;
        }
    }

    public Double getAge() {
        return aAge;
    }

    public void setAge(Double pAge) {
        if(pAge < 0) {
            throw new IllegalArgumentException("The age can't be smaller than 0");
        } else {
            this.aAge = pAge;
        }
    }

    public String getSpecies() { return aSpecies; }

    public void setSpecies(String aSpecies) { this.aSpecies = aSpecies; }
}
