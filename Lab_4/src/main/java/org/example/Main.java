package org.example;

import dataStructures.HashTable;

public class Main {
    static void main() {
        MyHash myHash = new MyHash(7);
        for (int i = 1; i <= 15; i++) {
            myHash.put(i, "k");
        }
        myHash.put(15, "a");
        myHash.output();
    }
}
