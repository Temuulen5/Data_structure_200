package org.example;

import dataStructures.HashChains;
import dataStructures.HashTable;

public class MyHash extends HashChains {
    public MyHash(int theDivisor) {
        super(theDivisor);
    }

    public Object updateElement(Object theKey, Object theValue) {
        Object object = get(theKey);
        if (object != null) {
            put(theKey, theValue);
        }
        return object;
    }

    public Object updateKey(Object theKey, Object theNewKey) {
        Object object = get(theKey);
        if (object != null) {
            remove(theKey);
            put(theNewKey, object);
        }
        return object;
    }

    public void delete(Object theKey) {
        remove(theKey);
    }
}
