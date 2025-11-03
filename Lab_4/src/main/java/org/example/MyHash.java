package org.example;

import dataStructures.HashChains;
import dataStructures.HashTable;

public class MyHash extends HashChains {
    public MyHash(int theDivisor) {
        super(theDivisor);
    }

    public Object updateElement(Object theKey, Object theValue) {
        Object oldElement = this.get(theKey);
        if (oldElement != null) {
            this.put(theKey, theValue);
            return oldElement;
        }
        return null;
    }

    public Object updateKey(Object theKey, Object theNewKey) {
        Object value = this.get(theKey);
        if (value != null) {
            this.delete(theKey);
            this.put(theNewKey, value);
        }
        return value;
    }

    public void delete(Object theKey) {
        Object object = this.get(theKey);
        if (object != null) {
            this.remove(theKey);
        }
    }
}
