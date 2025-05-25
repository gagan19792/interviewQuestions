package org.interview.questions.others;

import java.util.ArrayList;

public class HashTable {

    class Node{
        private String key;
        private Integer value;
        private Node next;

        Node(String key, Integer value){
            this.key = key;
            this.value = value;
        }
    }

    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    private int hashKey(String key){
        int hash = 0;
        char[] chars = key.toCharArray();
        for(int i=0; i< chars.length;i++){
            int asciieVal = chars[i];
            hash = (hash+asciieVal*23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, Integer val){
        int index = hashKey(key);
        Node newNode = new Node(key, val);
        if(dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
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
        while(temp!= null){
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
        for(int i=0; i< dataMap.length;i++){
            System.out.println(i+" : ");
            Node temp = dataMap[i];
            while(temp != null){
                System.out.println("{ "+temp.key+" : "+temp.value+" }");
                temp = temp.next;
            }

        }
    }
}
