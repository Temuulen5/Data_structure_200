package org.example;

import java.util.Hashtable;

public class Main {
    static void main() {
        MyHash myHash = new MyHash(11);
        myHash.put(46, 46);
        System.out.println(myHash.get(46));
        myHash.updateElement(46, 67);
        myHash.output();
        System.out.println(myHash.size());
    }
}
