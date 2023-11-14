package com.forezp.thread;


import java.util.HashMap;
import java.util.Map;
/**
 * @Author 王鑫涛
 * @Description TODO
 * @Date 2023-10-28  17:23
 **/
public class LRUCache {

        private final int capacity;
        private final Map<Integer, Node> cache;
        private final Node head;
        private final Node tail;

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new HashMap<>();
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void addToHead(Node node) {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }

        private void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                moveToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                addToHead(newNode);
                if (cache.size() > capacity) {
                    Node tailPrev = tail.prev;
                    removeNode(tailPrev);
                    cache.remove(tailPrev.key);
                }
            }
        }
}
