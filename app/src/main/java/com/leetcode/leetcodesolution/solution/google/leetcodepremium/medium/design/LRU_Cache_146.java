package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium.design;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class LRU_Cache_146 {
}

/**
 * 題目要求 add, remove 的 time complexity: O(1), 所以直覺就想到雙鍊結的 list + HashMap
 * space complexity: O(capacity)
 */
class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int k, int v) {
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }

    Node head;
    Node tail;
//    int count = 0;
    AtomicInteger count = new AtomicInteger(0);
    int capacity;
//    HashMap<Integer, Node> map;   // non thread safe
    ConcurrentHashMap<Integer, Node> map;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public LRUCache(int capacity) {
        AtomicInteger va = new AtomicInteger(3);
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
//        map = new HashMap<>();
        map = new ConcurrentHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            int value = map.get(key).value;
            remove(key);
            addToHead(key, value);
            return value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(key);
        }
        addToHead(key, value);
    }

    private void remove(int key) {
        // thread safe
        try{
            readWriteLock.writeLock().lock();
        Node cur = map.get(key);
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
        map.remove(key);
//        count--;
        count.decrementAndGet();
        }finally{
            readWriteLock.writeLock().unlock();
        }

        // non-thread safe
//        Node cur = map.get(key);
//        Node prev = cur.prev;
//        Node next = cur.next;
//        prev.next = next;
//        next.prev = prev;
//        map.remove(key);
//        count--;
    }

    private void addToHead(int key, int value) {

        // thread safe
        try{
        Node cur = new Node(key, value);
        Node next = head.next;
        head.next = cur;
        cur.next = next;

        next.prev = cur;
        cur.prev = head;
//        count++;
        count.incrementAndGet();
        map.put(key, cur);
//        if (count > capacity) {
        if (count.get() > capacity) {
            Node prevTail = tail.prev;
            prevTail.prev.next = tail;
            tail.prev = prevTail.prev;
            map.remove(prevTail.key);
//            count--;
            count.decrementAndGet();
        }
        }finally{
            readWriteLock.writeLock().unlock();
        }
        // non thread safe
//        Node cur = new Node(key, value);
//        Node next = head.next;
//        head.next = cur;
//        cur.next = next;
//
//        next.prev = cur;
//        cur.prev = head;
//        count++;
//        map.put(key, cur);
//        if (count > capacity) {
//            Node prevTail = tail.prev;
//            prevTail.prev.next = tail;
//            tail.prev = prevTail.prev;
//            map.remove(prevTail.key);
//            count--;
//        }
    }
}