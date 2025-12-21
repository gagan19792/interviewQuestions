package org.interview.questions.others;

import java.util.ArrayList;

public class HashTable {

    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();
        myHashTable.printHashTable();
        myHashTable.set("One",1);
        myHashTable.set("Two",2);
        myHashTable.set("owT",22);
        myHashTable.set("Three",3);
        myHashTable.printHashTable();
        System.out.println("Get Three : "+myHashTable.get("Three"));
    }
    private int size = 7;
    private Node[] dataMap;

    class Node {
        private String key;
        private int value;
        private Node next;

        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public HashTable(){
        dataMap = new Node[size];
    }

    private int hashKey(String key){
        int hashKey = 0;
        char[] ch = key.toCharArray();
        for(char c: ch){
            int asciiValue = (int)c;
            hashKey = (hashKey+asciiValue * 23) %dataMap.length;
        }
        return hashKey;
    }

    public void set(String key, int value){
        int index = hashKey(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else {
            Node temp = dataMap[index];
            while(temp.next !=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key){
        int index = hashKey(key);
        Node temp = dataMap[index];
        while(temp != null){
            if(temp.key == key) return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> allKeys(){
        ArrayList<String> keys = new ArrayList<>();
        for(int i = 0; i< dataMap.length; i++){
            Node temp = dataMap[i];
            while(temp !=null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    public void printHashTable(){
        for(int i=0 ;i<dataMap.length;i++){
            System.out.println(i+":");
            Node temp = dataMap[i];
            while(temp !=null){
                System.out.println("    {"+temp.key+" = "+temp.value+"}");
                temp = temp.next;
            }
        }
    }

}
