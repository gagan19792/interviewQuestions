package org.interview.oops.polymorphism;

public class Zoo {

    public static void main(String[] args) {
        // reference type is Animal, but actual type varies
        Animal[] animals = { new Dog(), new Cat() };
        for (Animal a : animals) {
            a.makeSound();  // dynamic dispatch picks Dog or Cat implementation
        }
    }
}
