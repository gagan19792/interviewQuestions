package org.interview.questions.others;

public class HashTableMain {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.printHashTable();
        hashTable.set("nail",100);
        hashTable.set("tile",50);
        hashTable.set("lumber",80);
        hashTable.set("bolts",200);
        hashTable.set("screws",140);
        hashTable.set("sscrew",120);
        hashTable.printHashTable();
        System.out.println(hashTable.get("bolts"));
        System.out.println(hashTable.get("abolts"));
        System.out.println(hashTable.allKeys());
    }
}
