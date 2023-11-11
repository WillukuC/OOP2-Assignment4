package com.champlain.oop2.oop2assignment4;

/**
 * Generic Animal class
 */
public class Animal {
    /**
     * Name of the Animal
     */
    private String aName;
    /**
     * Species of the Animal
     */
    private String aSpecies;
    /**
     * Weight of the Animal
     */
    private Double aWeight;
    /**
     * Age of the Animal
     */
    private Double aAge;

    /**
     * Animal Constructor
     * Sets Name and Species to default ""
     * Sets Weight and Age to default 0.0
     */
    public Animal(){
        aName = "";
        aSpecies = "";
        aWeight = 0.0;
        aAge = 0.0;
    }

    /**
     * Returns the name of the Animal
     * @return name of animal
     */
    public String getName() {
        return aName;
    }

    /**
     * Changes the name of the Animal
     * @param pName new name for the Animal
     */
    public void setName(String pName) {
        aName = pName;
    }

    /**
     * Returns the species of the Animal
     * @return species of the Animal
     */
    public String getSpecies() {
        return aSpecies;
    }

    /**
     * Changes the species of the Animal
     * @param pSpecies new species for the Animal
     */
    public void setSpecies(String pSpecies) {
        aSpecies = pSpecies;
    }

    /**
     * Returns the weight of the Animal
     * @return weight of Animal
     */
    public Double getWeight() {
        return aWeight;
    }

    /**
     * Sets the weight of the Animal. Must be between 0 and 10,000
     * (zoo may want to accommodate heavier animals, such as elephants)
     * @param pWeight Must be between 0 and 10,000
     */
    public void setWeight(Double pWeight) {
		if(pWeight <= 0) {
            throw new IllegalArgumentException("The weight must be greater than 0");
        } if(pWeight > 10000) {
            throw new IllegalArgumentException("The weight can't be greater than 10000");
        } else {
            this.aWeight = pWeight;
        }
    }

    /**
     * Returns the age of the Animal
     * @return age of Animal
     */
    public Double getAge() {
        return aAge;
    }

    /**
     * Sets the weight of the Animal. Must be above 0
     * @param pAge Must be above 0
     */
    public void setAge(Double pAge) {
        if(pAge < 0) {
            throw new IllegalArgumentException("The age can't be smaller than 0");
        } else {
            this.aAge = pAge;
        }
    }
}
