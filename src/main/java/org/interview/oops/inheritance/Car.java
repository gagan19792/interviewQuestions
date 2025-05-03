package org.interview.oops.inheritance;

// Subclass inherits behavior and can extend/override it
public class Car extends Vehicle {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " car starting");
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }
}
