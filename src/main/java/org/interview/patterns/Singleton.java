package org.interview.patterns;

public class Singleton {

    // Volatile ensures that multiple threads handle the instance variable correctly
    public static volatile Singleton instance;

    // Private constructor prevents instantiation from other classes
    private Singleton(){
    }

    // Public method to provide access to the instance
    public static Singleton getInstance(){
        if(instance == null){
            synchronized ((Singleton.class)){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
