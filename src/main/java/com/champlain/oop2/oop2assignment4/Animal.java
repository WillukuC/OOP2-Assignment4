package com.champlain.oop2.oop2assignment4;

public class Animal {

    public Animal(String pName){
        this.setName(pName);
    }
    private String aName;

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

    public void setAge(Double aAge) { this.aAge = aAge; }
}
