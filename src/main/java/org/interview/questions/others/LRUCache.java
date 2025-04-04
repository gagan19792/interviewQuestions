package org.interview.questions.others;

import java.util.HashMap;

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head;
        private Node tail;

        public LRUCache(int capacity){
            this.capacity=capacity;
            map = new HashMap<>();
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }
            Node node = map.get(key);
            //move access to head
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void put(int key, int value){
            //update
            if(map.containsKey(key)){
                Node node = map.get(key);
                node.value = value;
                removeNode(node);
                addToHead(node);
            }else{
                if(map.size() == capacity){
                    //remove last
                    Node lru = tail.prev;
                    removeNode(lru);
                    map.remove(lru.value);
                }
                //New node
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                addToHead(newNode);
            }
        }
        //Helper to remove Node
        public void removeNode(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        //Helper to add Node
        public void addToHead(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

    // For testing purposes
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3); // Capacity of 3
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);
        System.out.println("Get key 2: " + cache.get(2)); // Should print 200
        cache.put(4, 400); // This will evict key 1 as it is the least recently used
        System.out.println("Get key 1: " + cache.get(1)); // Should print -1 (not found)
        System.out.println("Get key 3: " + cache.get(3)); // Should print 300
        System.out.println("Get key 4: " + cache.get(4)); // Should print 400
    }

}
