package org.interview.patterns;

public enum SingletonWithEnum {
INSTANCE;


    // example method
    public void doSomething() {
        // …
    }
}
//Thread-safety	The JVM guarantees that enum values are instantiated once in a thread-safe way. No explicit synchronization is needed.
//Performance	Extremely fast: no synchronization or volatile checks on access, just a simple field lookup.
//Serialization	Enums provide their own serialization machinery. On deserialization, Java ensures you get back the same INSTANCE—you don’t need a readResolve().
//Reflection	Java prevents reflective creation of enum instances—if you try to call the enum constructor reflectively, you get an exception.