package com.champlain.oop2.oop2assignment4;

public class Animal {

    public Animal() {};

	public Animal(String pName){
        this.setName(pName);
    }
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

    /**
     * Sets the weight of the Animal. May be between 0 and 10,000
     * (zoo may want to accommodate heavier animals, such as elephants)
     * @param pWeight Must be between 0 and 10,000
     */
    public void setWeight(Double pWeight) {
		if(pWeight < 0) {
            throw new IllegalArgumentException("The weight can't be smaller than 0");
        } if(pWeight > 10000) {
            throw new IllegalArgumentException("The weight can't be greater than 10000");
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
